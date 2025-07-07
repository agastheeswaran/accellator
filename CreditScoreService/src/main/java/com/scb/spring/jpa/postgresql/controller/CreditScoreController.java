package com.scb.spring.jpa.postgresql.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.scb.spring.jpa.postgresql.dto.CreditScoreDto;
import com.scb.spring.jpa.postgresql.model.CreditScore;
import com.scb.spring.jpa.postgresql.repository.CreditScoreRepository;
import com.scb.spring.jpa.postgresql.repository.CustomerRepository;
import com.scb.spring.jpa.postgresql.service.ScoringService;

@RestController
@RequestMapping("/api/v1/credit-scores")
public class CreditScoreController {

	@Autowired
    private  CustomerRepository  customerRepo;
	
	@Autowired
    private  CreditScoreRepository scoreRepo;
	
	@Autowired
    private  ScoringService scoringSvc;

    /** Recompute a fresh score */
    @PostMapping("/refresh/{customerId}")
    public ResponseEntity<CreditScoreDto> refresh(@PathVariable Long customerId) {
        return customerRepo.findById(customerId)
                .map(scoringSvc::calculate)
                .map(this::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /** Retrieve most recent score */
    @GetMapping("/latestscore/{customerId}")
    public ResponseEntity<CreditScoreDto> latest(@PathVariable Long customerId) {
        CreditScore cs = scoreRepo.findTopByCustomerIdOrderByCalculatedAtDesc(customerId);
        return cs == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(toDto(cs));
    }

    private CreditScoreDto toDto(CreditScore c) {
        return new CreditScoreDto(
                c.getCustomer().getId(), c.getScore(), c.getGrade(), c.getCalculatedAt());
    }
}
