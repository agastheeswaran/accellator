package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.CreditScore;

public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {
    CreditScore findTopByCustomerIdOrderByCalculatedAtDesc(Long customerId);
}
