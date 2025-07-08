package com.scb.spring.jpa.postgresql.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Getter @Setter @NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    private LocalDate joinedOn = LocalDate.now();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditScore> creditScores = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankRelationship> relationships = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();
    
    public Customer() {
    	
    }

	public Customer(Long id, @NotBlank String firstName, @NotBlank String lastName, @Email String email,
			LocalDate joinedOn, List<CreditScore> creditScores, List<BankRelationship> relationships,
			List<Loan> loans) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.joinedOn = joinedOn;
		this.creditScores = creditScores;
		this.relationships = relationships;
		this.loans = loans;
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

	public List<CreditScore> getCreditScores() {
		return creditScores;
	}

	public void setCreditScores(List<CreditScore> creditScores) {
		this.creditScores = creditScores;
	}

	public List<BankRelationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<BankRelationship> relationships) {
		this.relationships = relationships;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
    
    
}
