package com.scb.spring.jpa.postgresql.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scb.spring.jpa.postgresql.model.InterestRateRequest;
import com.scb.spring.jpa.postgresql.model.InterestRateResponse;
import com.scb.spring.jpa.postgresql.service.InterestCalculatorService;

@RestController
@RequestMapping("/api/v1/interest")
public class InterestController {

    private final InterestCalculatorService svc;

    public InterestController(InterestCalculatorService svc) {
        this.svc = svc;
    }

    @PostMapping("/calculate")
    public ResponseEntity<InterestRateResponse> calculate(
            @RequestBody InterestRateRequest req) {

        return ResponseEntity.ok(svc.calculate(req));
    }
}
