package com.education.rural.persistence.repository;

import com.education.rural.persistence.entity.CampusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCampusRepository extends JpaRepository<CampusEntity, Long> {
}
