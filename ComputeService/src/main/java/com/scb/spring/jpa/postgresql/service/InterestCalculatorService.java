package com.scb.spring.jpa.postgresql.service;

//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.spring.jpa.postgresql.model.InterestRateRequest;
import com.scb.spring.jpa.postgresql.model.InterestRateResponse;
import com.scb.spring.jpa.postgresql.model.LoanType;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InterestCalculatorService {
	
//    @Autowired
//    private KieContainer kieContainer;  


    public InterestRateResponse calculate(InterestRateRequest r) {

        BigDecimal baseline = baselineForScore(r.getCreditScore());
        BigDecimal loanAdj  = (r.getLoanType() == LoanType.SECURED)
                              ? BigDecimal.valueOf(-0.30)   // -30 bp
                              : BigDecimal.ZERO;
        BigDecimal marketAdj = r.getMarketBaseRate()
                                .subtract(BigDecimal.valueOf(8.0))
                                .multiply(BigDecimal.valueOf(0.5));

        BigDecimal riskAdj = (r.getCreditScore() >= 800)
                             ? BigDecimal.ZERO
                             : BigDecimal.ONE.subtract(r.getRiskScore())
                                             .multiply(BigDecimal.valueOf(1.5));

        BigDecimal rate = baseline.add(loanAdj)
                                  .add(marketAdj)
                                  .add(riskAdj)
                                  .setScale(2, RoundingMode.HALF_UP);  // e.g. 9.20

        BigDecimal emi = computeEmi(r.getLoanAmount(), rate, r.getTenureMonths());
        BigDecimal totalInterest = emi.multiply(BigDecimal.valueOf(r.getTenureMonths()))
                                      .subtract(r.getLoanAmount())
                                      .setScale(2, RoundingMode.HALF_UP);

        return new InterestRateResponse(rate, emi, totalInterest);
    }
	
//	 public InterestRateResponse calculate(InterestRateRequest req) {
//
//	        /* --- run the rules --- */
//	        try (KieSession session = kieContainer.newKieSession()) {
//	            session.insert(req);
//	            session.fireAllRules();
//	        }
//
//	        /* --- Java finishes EMI & totals --- */
//	        BigDecimal rate  = req.getRate();                     // set by Drools
//	        BigDecimal emi   = computeEmi(req.getLoanAmount(), rate, req.getTenureMonths());
//	        BigDecimal total = emi.multiply(BigDecimal.valueOf(req.getTenureMonths()))
//	                              .subtract(req.getLoanAmount())
//	                              .setScale(2, RoundingMode.HALF_UP);
//
//	        return new InterestRateResponse(rate, emi, total);
//	    }


    // ─── helpers ─────────────────────────────────────────────────────

    private BigDecimal baselineForScore(int score) {
        if (score >= 800) return BigDecimal.valueOf(9.5);
        if (score >= 650) return BigDecimal.valueOf(11.0);
        return BigDecimal.valueOf(14.0);
    }

    /** standard annuity EMI formula */
    private BigDecimal computeEmi(BigDecimal principal,
                                  BigDecimal annualRate,
                                  int months) {

        BigDecimal r = annualRate.divide(BigDecimal.valueOf(12 * 100),
                                         10, RoundingMode.HALF_UP);
        BigDecimal onePlusRpowN = r.add(BigDecimal.ONE).pow(months);
        BigDecimal numerator   = principal.multiply(r).multiply(onePlusRpowN);
        BigDecimal denominator = onePlusRpowN.subtract(BigDecimal.ONE);
        return numerator.divide(denominator, 2, RoundingMode.HALF_UP);
    }
}
