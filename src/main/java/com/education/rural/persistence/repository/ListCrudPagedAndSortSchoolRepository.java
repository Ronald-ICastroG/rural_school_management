package com.education.rural.persistence.repository;

import com.education.rural.persistence.entity.SchoolEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ListCrudPagedAndSortSchoolRepository extends ListPagingAndSortingRepository<SchoolEntity, Long> {
}
