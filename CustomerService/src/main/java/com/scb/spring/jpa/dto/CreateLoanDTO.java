package  com.scb.spring.jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateLoanDTO(
        @NotNull @Positive BigDecimal principal,
        Boolean secured,
        String collateral,
        @NotNull @Min(1) Integer tenureMonths ) {}
