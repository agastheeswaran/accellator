package com.scb.spring.jpa.postgresql.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.spring.jpa.postgresql.model.CreditScore;
import com.scb.spring.jpa.postgresql.model.Customer;
import com.scb.spring.jpa.postgresql.model.ExternalSnapshot;
import com.scb.spring.jpa.postgresql.repository.CreditScoreRepository;

@Service
public class ScoringService {

	@Autowired
    private  ExternalDataService snapshotSvc;
	
	@Autowired
    private  CreditScoreRepository scoreRepo;

    public CreditScore calculate(Customer customer) {

        ExternalSnapshot macro = snapshotSvc.latest();

        /* ---------- very simple illustrative formula ---------- */
        int base = 680;   // start in FAIR zone

        double macroAdj =
                (macro.getRepoRate().doubleValue()       - 6.5) * -5 +
                (macro.getInflation().doubleValue()      - 4.0) * -3 +
                (macro.getUnemploymentRate().doubleValue() - 5) * -4 +
                macro.getGdpGrowth().doubleValue() * 2;

        int raw = Math.max(300, Math.min(900, (int) Math.round(base + macroAdj)));

        String grade = switch (raw) {
            case 750 -> "EXCELLENT";
            default  -> raw >= 750 ? "EXCELLENT"
                    : raw >= 700 ? "GOOD"
                    : raw >= 650 ? "FAIR"
                    : "POOR";
        };

        return scoreRepo.save(new CreditScore(null, customer, raw, grade, null));
    }
}
