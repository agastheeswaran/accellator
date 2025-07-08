package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.InterestRateRequest;



public interface InterestRateRequestRepository extends JpaRepository<InterestRateRequest, Long> {
}
