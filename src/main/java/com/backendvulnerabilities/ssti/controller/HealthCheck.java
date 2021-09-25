package com.backendvulnerabilities.ssti.controller;

import com.backendvulnerabilities.ssti.service.HealthCheckService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HealthCheck {

    @Autowired
    HealthCheckService service;

    @GetMapping("/api/healthcheck")
    public ResponseEntity check() {
        if(service.check()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
