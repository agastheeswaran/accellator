package com.scb.spring.jpa.dto;

import java.math.BigDecimal;

public class SnapshotRequest {

    private BigDecimal repoRate;
    private BigDecimal reverseRepoRate;
    private BigDecimal inflation;
    private BigDecimal gdpGrowth;
    private BigDecimal unemploymentRate;
    private BigDecimal fraudScoreAvg;
    private BigDecimal sentimentScoreAvg;
    
    public SnapshotRequest() {
    	
    }

	public SnapshotRequest(BigDecimal repoRate, BigDecimal reverseRepoRate, BigDecimal inflation, BigDecimal gdpGrowth,
			BigDecimal unemploymentRate, BigDecimal fraudScoreAvg, BigDecimal sentimentScoreAvg) {
		super();
		this.repoRate = repoRate;
		this.reverseRepoRate = reverseRepoRate;
		this.inflation = inflation;
		this.gdpGrowth = gdpGrowth;
		this.unemploymentRate = unemploymentRate;
		this.fraudScoreAvg = fraudScoreAvg;
		this.sentimentScoreAvg = sentimentScoreAvg;
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
