package com.scb.spring.jpa.postgresql.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.spring.jpa.postgresql.dto.CreateCustomerDTO;
import com.scb.spring.jpa.postgresql.dto.CustomerResponseDTO;
import com.scb.spring.jpa.postgresql.model.Customer;
import com.scb.spring.jpa.postgresql.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	/* ------------ Customers ------------ */
	public CustomerResponseDTO createCustomer(CreateCustomerDTO dto) {
		Customer c = new Customer();
		c.setFirstName(dto.firstName() );
		c.setLastName(dto.lastName());
		c.setEmail(dto.email());
		Customer cust = customerRepo.save(c);
		 
		CustomerResponseDTO custdto = mapCustomerToCustomerResponseDTO(cust);

		 return custdto;
	}
	
	public CustomerResponseDTO mapCustomerToCustomerResponseDTO(Customer c) {
		return new CustomerResponseDTO(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getJoinedOn());
	}

}
