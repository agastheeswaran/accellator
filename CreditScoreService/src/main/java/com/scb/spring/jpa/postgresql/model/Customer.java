package com.scb.spring.jpa.postgresql.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pan;
    private String firstName;

    private String lastName;

    private String email;	
    private LocalDate joinedOn = LocalDate.now();

    private LocalDateTime dateOfBirth;
	private String riskSegment; // e.g. SALARIED / SELF_EMP / SME

	public Customer() {

	}

	public Customer(Long id, String pan, String firstName, String lastName, String email, 
			LocalDateTime dateOfBirth,LocalDate joinedOn,
			String riskSegment) {
		super();
		this.id = id;
		this.pan = pan;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.joinedOn =  joinedOn;
		this.riskSegment = riskSegment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRiskSegment() {
		return riskSegment;
	}

	public void setRiskSegment(String riskSegment) {
		this.riskSegment = riskSegment;
	}

	public LocalDate getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(LocalDate joinedOn) {
		this.joinedOn = joinedOn;
	}



}
