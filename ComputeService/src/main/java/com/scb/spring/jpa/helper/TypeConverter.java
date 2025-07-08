package com.scb.spring.jpa.helper;

import org.springframework.stereotype.Component;

import com.scb.spring.jpa.dto.CustomerResponseDTO;
import com.scb.spring.jpa.postgresql.model.Customer;

@Component
public class TypeConverter {

	public CustomerResponseDTO mapCustomerToCustomerResponseDTO(Customer c) {
		return new CustomerResponseDTO(c.getId(), 
				c.getFirstName(), 
				c.getLastName(), 
				c.getEmail(), 
				c.getJoinedOn());
	}

}
