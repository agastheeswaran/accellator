package com.scb.spring.jpa.postgresql.dto;

import java.time.LocalDateTime;

public class CreditScoreDto {
	
    private Long customerId;
    private Integer score;
    private String grade;
    private LocalDateTime calculatedAt;
    
    public CreditScoreDto() {}

	public CreditScoreDto(Long customerId, Integer score, String grade, LocalDateTime calculatedAt) {
		super();
		this.customerId = customerId;
		this.score = score;
		this.grade = grade;
		this.calculatedAt = calculatedAt;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public LocalDateTime getCalculatedAt() {
		return calculatedAt;
	}

	public void setCalculatedAt(LocalDateTime calculatedAt) {
		this.calculatedAt = calculatedAt;
	}
    
    

}
