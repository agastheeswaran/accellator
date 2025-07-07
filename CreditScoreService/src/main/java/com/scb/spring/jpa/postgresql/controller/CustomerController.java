package com.scb.spring.jpa.postgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.spring.jpa.postgresql.dto.CreateCustomerDTO;
import com.scb.spring.jpa.postgresql.dto.CustomerResponseDTO;
import com.scb.spring.jpa.postgresql.service.CustomerService;


@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {
	
	@Autowired
    private  CustomerService service;
	
    @PostMapping("/createcustomer/{id}")
    public ResponseEntity<CustomerResponseDTO> create(@RequestBody @Validated CreateCustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(dto));
    }

}
