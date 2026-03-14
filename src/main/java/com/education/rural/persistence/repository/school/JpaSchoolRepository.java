package com.education.rural.persistence.repository.school;

import com.education.rural.persistence.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSchoolRepository extends JpaRepository<SchoolEntity, Long> {
}
