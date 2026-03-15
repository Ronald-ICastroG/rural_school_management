package com.education.rural.persistence.repository.Institutional.school;

import com.education.rural.persistence.entity.Institutional.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSchoolRepository extends JpaRepository<SchoolEntity, Long> {
}
