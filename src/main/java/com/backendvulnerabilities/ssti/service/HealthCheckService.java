package com.backendvulnerabilities.ssti.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HealthCheckService {

    public boolean check() {
        File file = new File("/etc/passwd");
        return file.exists();
    }
}
