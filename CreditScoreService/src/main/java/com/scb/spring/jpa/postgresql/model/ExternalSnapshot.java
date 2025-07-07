package com.scb.spring.jpa.postgresql.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExternalSnapshot {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime capturedAt = LocalDateTime.now();

    /* ---- Market rates ---- */
    private BigDecimal repoRate;
    private BigDecimal reverseRepoRate;

    /* ---- Economic indicators ---- */
    private BigDecimal inflation;
    private BigDecimal gdpGrowth;

    /* ---- Industry risks ---- */
    private BigDecimal unemploymentRate;

    /* ---- Optional social signals ---- */
    private BigDecimal fraudScoreAvg;
    private BigDecimal sentimentScoreAvg;
    
    public ExternalSnapshot() {
    	
    }

	public ExternalSnapshot(Long id, LocalDateTime capturedAt, BigDecimal repoRate, BigDecimal reverseRepoRate,
			BigDecimal inflation, BigDecimal gdpGrowth, BigDecimal unemploymentRate, BigDecimal fraudScoreAvg,
			BigDecimal sentimentScoreAvg) {
		super();
		this.id = id;
		this.capturedAt = capturedAt;
		this.repoRate = repoRate;
		this.reverseRepoRate = reverseRepoRate;
		this.inflation = inflation;
		this.gdpGrowth = gdpGrowth;
		this.unemploymentRate = unemploymentRate;
		this.fraudScoreAvg = fraudScoreAvg;
		this.sentimentScoreAvg = sentimentScoreAvg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCapturedAt() {
		return capturedAt;
	}

	public void setCapturedAt(LocalDateTime capturedAt) {
		this.capturedAt = capturedAt;
	}

	public BigDecimal getRepoRate() {
		return repoRate;
	}

	public void setRepoRate(BigDecimal repoRate) {
		this.repoRate = repoRate;
	}

	public BigDecimal getReverseRepoRate() {
		return reverseRepoRate;
	}

	public void setReverseRepoRate(BigDecimal reverseRepoRate) {
		this.reverseRepoRate = reverseRepoRate;
	}

	public BigDecimal getInflation() {
		return inflation;
	}

	public void setInflation(BigDecimal inflation) {
		this.inflation = inflation;
	}

	public BigDecimal getGdpGrowth() {
		return gdpGrowth;
	}

	public void setGdpGrowth(BigDecimal gdpGrowth) {
		this.gdpGrowth = gdpGrowth;
	}

	public BigDecimal getUnemploymentRate() {
		return unemploymentRate;
	}

	public void setUnemploymentRate(BigDecimal unemploymentRate) {
		this.unemploymentRate = unemploymentRate;
	}

	public BigDecimal getFraudScoreAvg() {
		return fraudScoreAvg;
	}

	public void setFraudScoreAvg(BigDecimal fraudScoreAvg) {
		this.fraudScoreAvg = fraudScoreAvg;
	}

	public BigDecimal getSentimentScoreAvg() {
		return sentimentScoreAvg;
	}

	public void setSentimentScoreAvg(BigDecimal sentimentScoreAvg) {
		this.sentimentScoreAvg = sentimentScoreAvg;
	}
    
    
}
