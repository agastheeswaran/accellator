package com.scb.spring.jpa.postgresql.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scb.spring.jpa.postgresql.dto.SnapshotDto;
import com.scb.spring.jpa.postgresql.dto.SnapshotRequest;
import com.scb.spring.jpa.postgresql.model.ExternalSnapshot;
import com.scb.spring.jpa.postgresql.service.ExternalDataService;

@RestController
@RequestMapping("/api/v1/snapshots")
public class ExternalDataController {

	@Autowired
    private  ExternalDataService svc;

    /** Admin endpoint to insert/update macro snapshot */
    @PostMapping("/updateexternalscore")
    public ResponseEntity<SnapshotDto> create(@RequestBody SnapshotRequest req) {
        return ResponseEntity.ok(svc.save(req));
    }

    /** Anyone can fetch the latest macro data */
    @GetMapping("/latestexternalscore")
    public ResponseEntity<ExternalSnapshot> latest() {
        return ResponseEntity.ok(svc.latest());
    }
}
