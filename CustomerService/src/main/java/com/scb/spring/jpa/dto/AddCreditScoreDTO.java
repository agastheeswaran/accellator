package com.scb.spring.jpa.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AddCreditScoreDTO(
        @NotNull @Min(300) @Max(900) Integer score,
        String bureau) {}
