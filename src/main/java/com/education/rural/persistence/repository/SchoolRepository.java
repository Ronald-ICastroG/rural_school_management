package com.education.rural.persistence.repository;

import com.education.rural.persistence.entity.SchoolEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolRepository {
    private final CrudSchoolRepository crudSchoolRepository;
    private final SchoolEntity schoolEntity;

    public SchoolRepository(CrudSchoolRepository crudSchoolRepository, SchoolEntity schoolEntity) {
        this.crudSchoolRepository = crudSchoolRepository;
        this.schoolEntity = schoolEntity;
    }

    public List<SchoolEntity> findAll() {
        return this.crudSchoolRepository.findAll();
    }

    public SchoolEntity findById(Long id) {
        return this.crudSchoolRepository.findById(id).orElse(null);
    }
    public SchoolEntity save(SchoolEntity schoolEntity) {
        return this.crudSchoolRepository.save(schoolEntity);
    }

}
