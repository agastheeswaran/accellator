package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.CreditScore;

import java.util.Optional;

public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {
    Optional<CreditScore> findTopByCustomerIdOrderByEvaluatedOnDesc(Long customerId);
    
    Optional<CreditScore> findFirstByCustomerIdOrderByEvaluatedOnDesc(Long customerId);

}
