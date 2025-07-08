package com.scb.spring.jpa.postgresql.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.spring.jpa.dto.SnapshotDto;
import com.scb.spring.jpa.dto.SnapshotRequest;
import com.scb.spring.jpa.postgresql.model.ExternalSnapshot;
import com.scb.spring.jpa.postgresql.repository.ExternalSnapshotRepository;

@Service
public class ExternalDataService {

	@Autowired
    private  ExternalSnapshotRepository repo;

    public SnapshotDto save(SnapshotRequest req) {
        ExternalSnapshot snap = new ExternalSnapshot();
        snap.setRepoRate(req.getRepoRate());
        snap.setReverseRepoRate(req.getReverseRepoRate());
        snap.setInflation(req.getInflation());
        snap.setGdpGrowth(req.getGdpGrowth());
        snap.setUnemploymentRate(req.getUnemploymentRate());
        snap.setFraudScoreAvg(req.getFraudScoreAvg());
        snap.setSentimentScoreAvg(req.getSentimentScoreAvg());

        ExternalSnapshot saved = repo.save(snap);
        return toDto(saved);
    }

    public ExternalSnapshot latest() {
        ExternalSnapshot snap = repo.findTopByOrderByCapturedAtDesc();
        if (snap == null) {
            throw new IllegalStateException("No macro-economic snapshot found; seed the table first.");
        }
        return snap;
    }

    private SnapshotDto toDto(ExternalSnapshot e) {
        return new SnapshotDto(
                e.getId(), e.getCapturedAt(),
                e.getRepoRate(), e.getInflation(), e.getUnemploymentRate());
    }
}
