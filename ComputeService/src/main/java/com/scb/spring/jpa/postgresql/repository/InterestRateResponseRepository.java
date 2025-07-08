package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.spring.jpa.postgresql.model.InterestRateRequest;
import com.scb.spring.jpa.postgresql.model.InterestRateResponse;




public interface InterestRateResponseRepository extends JpaRepository<InterestRateResponse, Long> {}
