package  com.scb.spring.jpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerDTO(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email String email) {}
