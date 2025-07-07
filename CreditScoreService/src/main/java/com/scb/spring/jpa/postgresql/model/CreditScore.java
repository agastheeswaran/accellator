package com.scb.spring.jpa.postgresql.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CreditScore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer customer;

    private Integer score;          // 300-900
    private String  grade;          // POOR / FAIR / GOOD / EXCELLENT
    private LocalDateTime calculatedAt = LocalDateTime.now();
    
    
    public CreditScore() {
    	
    }


	public CreditScore(Long id, Customer customer, Integer score, String grade, LocalDateTime calculatedAt) {
		super();
		this.id = id;
		this.customer = customer;
		this.score = score;
		this.grade = grade;
		this.calculatedAt = calculatedAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
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
