package com.backendvulnerabilities.ssti.repository;

import com.backendvulnerabilities.ssti.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
