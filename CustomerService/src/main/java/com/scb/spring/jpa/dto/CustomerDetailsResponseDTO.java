package com.scb.spring.jpa.dto;

import java.time.LocalDate;

public class CustomerDetailsResponseDTO {
	
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private LocalDate joinedOn = LocalDate.now();
	
	private CustomerLoanResponseDTO loan;
	
	private CustomerCreditScoreResponseDTO creditscore;
	
	private CustomerBankRelationshipResponseDTO bankrelationship;
	
	public CustomerDetailsResponseDTO() {
		
	}

	public CustomerDetailsResponseDTO(Long id, String firstName, String lastName, String email, LocalDate joinedOn,
			CustomerLoanResponseDTO loan, CustomerCreditScoreResponseDTO creditscore,
			CustomerBankRelationshipResponseDTO bankrelationship) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.joinedOn = joinedOn;
		this.loan = loan;
		this.creditscore = creditscore;
		this.bankrelationship = bankrelationship;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(LocalDate joinedOn) {
		this.joinedOn = joinedOn;
	}

	public CustomerLoanResponseDTO getLoan() {
		return loan;
	}

	public void setLoan(CustomerLoanResponseDTO loan) {
		this.loan = loan;
	}

	public CustomerCreditScoreResponseDTO getCreditscore() {
		return creditscore;
	}

	public void setCreditscore(CustomerCreditScoreResponseDTO creditscore) {
		this.creditscore = creditscore;
	}

	public CustomerBankRelationshipResponseDTO getBankrelationship() {
		return bankrelationship;
	}

	public void setBankrelationship(CustomerBankRelationshipResponseDTO bankrelationship) {
		this.bankrelationship = bankrelationship;
	}
	
	

}
