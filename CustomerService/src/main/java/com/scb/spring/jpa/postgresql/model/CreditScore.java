package com.scb.spring.jpa.postgresql.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
//@Getter @Setter @NoArgsConstructor
public class CreditScore {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(300) @Max(900)
    private Integer score;

    private String bureau;

    private LocalDate evaluatedOn = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    
    public CreditScore() {
    	
    }

	public CreditScore(Long id, @Min(300) @Max(900) Integer score, String bureau, LocalDate evaluatedOn,
			Customer customer) {
		super();
		this.id = id;
		this.score = score;
		this.bureau = bureau;
		this.evaluatedOn = evaluatedOn;
		this.customer = customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
    
}
