package com.education.rural.persistence.repository.grade;

import com.education.rural.persistence.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGradeRepository extends JpaRepository<GradeEntity, Integer> {
    GradeEntity findFirstByGradeNameIgnoreCase(String name);
}
