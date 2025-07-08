package com.scb.spring.jpa.postgresql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	
    Optional<Loan> findFirstByCustomerIdOrderByStartDateDesc(Long customerId);

    
}
