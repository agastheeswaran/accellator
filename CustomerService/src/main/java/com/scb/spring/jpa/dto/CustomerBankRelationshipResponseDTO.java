package com.scb.spring.jpa.dto;

public class CustomerBankRelationshipResponseDTO {

	private Long id;

	private String loyaltyTier;

	private Integer productsHeld;

	public CustomerBankRelationshipResponseDTO() {

	}

	public CustomerBankRelationshipResponseDTO(Long id, String loyaltyTier, Integer productsHeld) {
		super();
		this.id = id;
		this.loyaltyTier = loyaltyTier;
		this.productsHeld = productsHeld;
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

}
