package com.scb.spring.jpa.postgresql.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InterestRateRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal loanAmount;
    private int tenureMonths;
    private int creditScore;
    private LoanType loanType;
    private BigDecimal marketBaseRate;
    private BigDecimal riskScore;   // 0–1, 1 = low risk
    private BigDecimal rate;        // calculated interest rate

    public InterestRateRequest() {}   // JSON-binding ctor



    /* Getters & setters */

    public InterestRateRequest(Long id, BigDecimal loanAmount, int tenureMonths, int creditScore, LoanType loanType,
			BigDecimal marketBaseRate, BigDecimal riskScore) {
		super();
		this.id = id;
		this.loanAmount = loanAmount;
		this.tenureMonths = tenureMonths;
		this.creditScore = creditScore;
		this.loanType = loanType;
		this.marketBaseRate = marketBaseRate;
		this.riskScore = riskScore;
	}



	public BigDecimal getLoanAmount()   { return loanAmount; }
    public void setLoanAmount(BigDecimal loanAmount) { this.loanAmount = loanAmount; }

    public int getTenureMonths()        { return tenureMonths; }
    public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

    public int getCreditScore()         { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }

    public LoanType getLoanType()       { return loanType; }
    public void setLoanType(LoanType loanType) { this.loanType = loanType; }

    public BigDecimal getMarketBaseRate() { return marketBaseRate; }
    public void setMarketBaseRate(BigDecimal marketBaseRate) { this.marketBaseRate = marketBaseRate; }

    public BigDecimal getRiskScore()    { return riskScore; }
    public void setRiskScore(BigDecimal riskScore) { this.riskScore = riskScore; }
    
    public BigDecimal getRate()         { return rate; }
    public void setRate(BigDecimal rate) { this.rate = rate; }
}
