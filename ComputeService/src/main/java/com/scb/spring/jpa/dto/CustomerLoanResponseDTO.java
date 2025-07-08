package com.scb.spring.jpa.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerLoanResponseDTO {
	
    private Long id;

    private BigDecimal principal;

    private Boolean secured;

    private String collateral;

    private Integer tenureMonths;

    private LocalDate startDate;

    private LocalDate expectedEndDate;
    
    public CustomerLoanResponseDTO() {}

	public CustomerLoanResponseDTO(Long id, BigDecimal principal, Boolean secured, String collateral,
			Integer tenureMonths, LocalDate startDate, LocalDate expectedEndDate) {
		super();
		this.id = id;
		this.principal = principal;
		this.secured = secured;
		this.collateral = collateral;
		this.tenureMonths = tenureMonths;
		this.startDate = startDate;
		this.expectedEndDate = expectedEndDate;
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
    
    

}
