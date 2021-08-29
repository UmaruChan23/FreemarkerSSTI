package com.backendvulnerabilities.ssti.repository;

import com.backendvulnerabilities.ssti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
