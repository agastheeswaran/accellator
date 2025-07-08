package com.scb.spring.jpa.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.spring.jpa.postgresql.model.ExternalSnapshot;

@Repository
public interface ExternalSnapshotRepository extends JpaRepository<ExternalSnapshot, Long> {
    ExternalSnapshot findTopByOrderByCapturedAtDesc();
}