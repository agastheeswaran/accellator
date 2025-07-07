package com.scb.spring.jpa.postgresql.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SnapshotDto {
    private Long id;
    private LocalDateTime capturedAt;
    private BigDecimal repoRate;
    private BigDecimal inflation;
    private BigDecimal unemploymentRate;
    
    public SnapshotDto() {
    	
    }

	public SnapshotDto(Long id, LocalDateTime capturedAt, BigDecimal repoRate, BigDecimal inflation,
			BigDecimal unemploymentRate) {
		super();
		this.id = id;
		this.capturedAt = capturedAt;
		this.repoRate = repoRate;
		this.inflation = inflation;
		this.unemploymentRate = unemploymentRate;
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

	public BigDecimal getInflation() {
		return inflation;
	}

	public void setInflation(BigDecimal inflation) {
		this.inflation = inflation;
	}

	public BigDecimal getUnemploymentRate() {
		return unemploymentRate;
	}

	public void setUnemploymentRate(BigDecimal unemploymentRate) {
		this.unemploymentRate = unemploymentRate;
	}
    
    
}
