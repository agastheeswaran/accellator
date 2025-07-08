package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.BankRelationship;

import java.util.Optional;

public interface BankRelationshipRepository extends JpaRepository<BankRelationship, Long> {
    Optional<BankRelationship> findByCustomerId(Long customerId);
    

}
