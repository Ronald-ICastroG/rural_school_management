package com.education.rural.persistence.repository;

import com.education.rural.persistence.entity.SchoolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.awt.print.Pageable;

public interface ListCrudPagedAndSortSchoolRepository extends ListPagingAndSortingRepository<SchoolEntity, Long> {
}
