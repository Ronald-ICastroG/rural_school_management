package com.education.rural.persistence.repository.Academic.Gradebook;

import com.education.rural.persistence.entity.Academic.GradebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGradebookRepository extends JpaRepository<GradebookEntity, Integer> {
}
