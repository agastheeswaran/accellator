package com.scb.spring.jpa.postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
public class BankRelationship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String loyaltyTier;

	private Integer productsHeld;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	public BankRelationship() {

	}

	public BankRelationship(Long id, String loyaltyTier, Integer productsHeld, Customer customer) {
		super();
		this.id = id;
		this.loyaltyTier = loyaltyTier;
		this.productsHeld = productsHeld;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoyaltyTier() {
		return loyaltyTier;
	}

	public void setLoyaltyTier(String loyaltyTier) {
		this.loyaltyTier = loyaltyTier;
	}

	public Integer getProductsHeld() {
		return productsHeld;
	}

	public void setProductsHeld(Integer productsHeld) {
		this.productsHeld = productsHeld;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
