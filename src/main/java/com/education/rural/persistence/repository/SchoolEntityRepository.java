package com.education.rural.persistence.repository;

import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.repository.SchoolRepository;
import com.education.rural.persistence.entity.SchoolEntity;
import com.education.rural.persistence.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolEntityRepository implements SchoolRepository {
    private final CrudSchoolRepository crudSchoolRepository;
    private final SchoolMapper schoolMapper;



    public SchoolEntityRepository(CrudSchoolRepository crudSchoolRepository, SchoolMapper schoolMapper) {
        this.crudSchoolRepository = crudSchoolRepository;
        this.schoolMapper = schoolMapper;
    }



    @Override
    public List<SchoolDto> getAll() {
        this.crudSchoolRepository.findAll();
        return this.schoolMapper.schoolToDto(this.crudSchoolRepository.findAll());
    }

    @Override
    public SchoolDto getById(long id) {
        return this.schoolMapper.schoolToDto(this.crudSchoolRepository.findById(id).orElse(null));
    }

    @Override
    public SchoolDto save(SchoolDto schoolDto) {
        if (getById(schoolDto.escId()) != null) {
            throw new RuntimeException("el título " + schoolDto + "ya existe");
        }
        SchoolEntity schoolEntity = this.schoolMapper.dtoToEntity(schoolDto);
        return this.schoolMapper.schoolToDto(schoolEntity);
    }

}
