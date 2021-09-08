package com.backendvulnerabilities.ssti.repository;

import com.backendvulnerabilities.ssti.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Item, Long> {
}
