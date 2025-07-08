package com.scb.spring.jpa.postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Getter @Setter @NoArgsConstructor
public class Loan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal principal;

    private Boolean secured;

    private String collateral;

    private Integer tenureMonths;

    private LocalDate startDate;

    private LocalDate expectedEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentHistory> repayments = new ArrayList<>();
    
    public Loan() {
    	
    }

	public Loan(Long id, BigDecimal principal, Boolean secured, String collateral, Integer tenureMonths,
			LocalDate startDate, LocalDate expectedEndDate, Customer customer, List<PaymentHistory> repayments) {
		super();
		this.id = id;
		this.principal = principal;
		this.secured = secured;
		this.collateral = collateral;
		this.tenureMonths = tenureMonths;
		this.startDate = startDate;
		this.expectedEndDate = expectedEndDate;
		this.customer = customer;
		this.repayments = repayments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public Boolean getSecured() {
		return secured;
	}

	public void setSecured(Boolean secured) {
		this.secured = secured;
	}

	public String getCollateral() {
		return collateral;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}

	public Integer getTenureMonths() {
		return tenureMonths;
	}

	public void setTenureMonths(Integer tenureMonths) {
		this.tenureMonths = tenureMonths;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(LocalDate expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<PaymentHistory> getRepayments() {
		return repayments;
	}

	public void setRepayments(List<PaymentHistory> repayments) {
		this.repayments = repayments;
	}
    
    
}
