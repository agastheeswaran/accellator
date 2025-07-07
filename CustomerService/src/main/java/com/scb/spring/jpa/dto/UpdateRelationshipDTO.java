package com.scb.spring.jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateRelationshipDTO(
        @NotBlank String loyaltyTier,
        @NotNull @Min(0) Integer productsHeld) {}
