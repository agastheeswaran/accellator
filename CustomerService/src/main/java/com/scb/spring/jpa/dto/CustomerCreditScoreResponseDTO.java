package com.scb.spring.jpa.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CustomerCreditScoreResponseDTO {
	
    private Long id;

    private Integer score;

    private String bureau;

    private LocalDate evaluatedOn = LocalDate.now();
    
    public CustomerCreditScoreResponseDTO() {
    	
    }

	public CustomerCreditScoreResponseDTO(Long id, Integer score, String bureau, LocalDate evaluatedOn) {
		super();
		this.id = id;
		this.score = score;
		this.bureau = bureau;
		this.evaluatedOn = evaluatedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public LocalDate getEvaluatedOn() {
		return evaluatedOn;
	}

	public void setEvaluatedOn(LocalDate evaluatedOn) {
		this.evaluatedOn = evaluatedOn;
	}
    
    

}
