package com.education.rural.persistence.repository;

import com.education.rural.persistence.entity.SchoolEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudSchoolRepository extends CrudRepository<SchoolEntity, Long> {
}
