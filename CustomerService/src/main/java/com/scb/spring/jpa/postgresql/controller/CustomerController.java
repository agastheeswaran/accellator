package com.scb.spring.jpa.postgresql.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.scb.spring.jpa.dto.AddCreditScoreDTO;
import com.scb.spring.jpa.dto.CreateCustomerDTO;
import com.scb.spring.jpa.dto.CreateLoanDTO;
import com.scb.spring.jpa.dto.CustomerDetailsResponseDTO;
import com.scb.spring.jpa.dto.CustomerResponseDTO;
import com.scb.spring.jpa.dto.RecordPaymentDTO;
import com.scb.spring.jpa.dto.UpdateRelationshipDTO;
import com.scb.spring.jpa.postgresql.model.BankRelationship;
import com.scb.spring.jpa.postgresql.model.CreditScore;
import com.scb.spring.jpa.postgresql.model.Customer;
import com.scb.spring.jpa.postgresql.model.Loan;
import com.scb.spring.jpa.postgresql.model.PaymentHistory;
import com.scb.spring.jpa.postgresql.service.CustomerService;
import com.scb.spring.jpa.helper.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {

	@Autowired
    private  CustomerService service;
	
	
	
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id) {
		CustomerResponseDTO dto = service.getCustomer(id);  // may throw if missing
	    return ResponseEntity.ok(dto); 
	    }
	
	@GetMapping("/getcustomerdetails/{id}")
	public ResponseEntity<CustomerDetailsResponseDTO> getCustomerDetails(@PathVariable Long id) {
		CustomerDetailsResponseDTO dto = service.getCustomerDetails(id);  // may throw if missing
	    return ResponseEntity.ok(dto); 
	    }

    /* --- Customer --- */
    @PostMapping("/createcustomer/{id}")
    public ResponseEntity<CustomerResponseDTO> create(@RequestBody @Validated CreateCustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(dto));
    }

    /* --- Credit Score --- */
    @PostMapping("/credit-scores/{id}")
    public CreditScore addScore(@PathVariable Long id,
                                @RequestBody @Validated AddCreditScoreDTO dto) {
        return service.addCreditScore(id, dto);
    }

    /* --- Bank Relationship --- */
    @PostMapping("/relationship/{id}")
    public BankRelationship updateRel(@PathVariable Long id,
                                      @RequestBody @Validated UpdateRelationshipDTO dto) {
        return service.updateRelationship(id, dto);
    }

    /* --- Loan --- */
    @PostMapping("/loans/{id}")
    public Loan createLoan(@PathVariable Long id,
                           @RequestBody @Validated CreateLoanDTO dto) {
        return service.createLoan(id, dto);
    }

    /* --- Payment --- */
    @PostMapping("/loans/payments/{loanId}")
    public PaymentHistory makePayment(@PathVariable Long loanId,
                                      @RequestBody @Validated RecordPaymentDTO dto) {
        return service.recordPayment(loanId, dto);
    }
    
    public CustomerResponseDTO mapCustomerToCustomerResponseDTO(Customer c) {
        return new CustomerResponseDTO(
                c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getJoinedOn()
        );
    }
}
