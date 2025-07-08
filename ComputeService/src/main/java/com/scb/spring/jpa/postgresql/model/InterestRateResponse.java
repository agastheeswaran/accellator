package com.scb.spring.jpa.postgresql.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InterestRateResponse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal personalizedRate;   // annual %
    private BigDecimal monthlyEmi;
    private BigDecimal totalInterest;

    public InterestRateResponse() {}

    public InterestRateResponse( BigDecimal personalizedRate, BigDecimal monthlyEmi, BigDecimal totalInterest) {
		super();
		this.personalizedRate = personalizedRate;
		this.monthlyEmi = monthlyEmi;
		this.totalInterest = totalInterest;
	}

    /* Getters only – immutable outward */

    public InterestRateResponse(Long id, BigDecimal personalizedRate, BigDecimal monthlyEmi, BigDecimal totalInterest) {
		super();
		this.id = id;
		this.personalizedRate = personalizedRate;
		this.monthlyEmi = monthlyEmi;
		this.totalInterest = totalInterest;
	}



	public BigDecimal getPersonalizedRate() { return personalizedRate; }
    public BigDecimal getMonthlyEmi()       { return monthlyEmi; }
    public BigDecimal getTotalInterest()    { return totalInterest; }
}
