package  com.scb.spring.jpa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RecordPaymentDTO(
        @NotNull @Positive BigDecimal amount,
        @Pattern(regexp = "ON_TIME|LATE|DEFAULTED") String status) {}
