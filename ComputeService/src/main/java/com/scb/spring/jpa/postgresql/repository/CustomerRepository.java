package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
