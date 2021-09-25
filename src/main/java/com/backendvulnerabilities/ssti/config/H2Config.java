package com.backendvulnerabilities.ssti.config;

import com.backendvulnerabilities.ssti.entity.Role;
import com.backendvulnerabilities.ssti.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class H2Config {

    @Autowired
    RoleRepository repository;

    @PostConstruct
    private void postConstruct() {
        Role role = new Role(1L, "ROLE_USER");
        repository.save(role);
    }
}
