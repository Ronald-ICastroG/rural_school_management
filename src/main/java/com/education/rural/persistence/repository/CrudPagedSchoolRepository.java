package com.education.rural.persistence.repository;

import com.education.rural.persistence.entity.SchoolEntity;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface CrudPagedSchoolRepository extends CrudRepository<SchoolEntity, Pageable> {
}
