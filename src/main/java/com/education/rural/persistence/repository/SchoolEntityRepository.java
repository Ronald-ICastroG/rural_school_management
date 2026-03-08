package com.education.rural.persistence.repository;

import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.dto.UpdateSchoolDto;
import com.education.rural.domain.repository.SchoolRepository;
import com.education.rural.persistence.entity.SchoolEntity;
import com.education.rural.persistence.mapper.SchoolMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolEntityRepository implements SchoolRepository {
    private final JpaSchoolRepository jpaSchoolRepository;
    private final SchoolMapper schoolMapper;



    public SchoolEntityRepository(JpaSchoolRepository jpaSchoolRepository, SchoolMapper schoolMapper) {
        this.jpaSchoolRepository = jpaSchoolRepository;
        this.schoolMapper = schoolMapper;
    }



    @Override
    public List<SchoolDto> getAll() {
        this.jpaSchoolRepository.findAll();
        return this.schoolMapper.schoolToDto(this.jpaSchoolRepository.findAll());
    }

    @Override
    public SchoolDto getById(long id) {
        return this.schoolMapper.schoolToDto(this.jpaSchoolRepository.findById(id).orElse(null));
    }

    @Override
    public SchoolDto save(SchoolDto schoolDto) {
        if (getById(schoolDto.escId()) != null) {
            throw new RuntimeException("el título " + schoolDto + "ya existe");
        }
        SchoolEntity schoolEntity = this.schoolMapper.dtoToEntity(schoolDto);
        return this.schoolMapper.schoolToDto(this.jpaSchoolRepository.save(schoolEntity));
    }


    public SchoolDto update(long id, UpdateSchoolDto updateSchoolDto) {
        SchoolEntity schoolEntity=this.jpaSchoolRepository.findById(id).orElse(null);
        if(schoolEntity==null) {
            throw new RuntimeException("School not found");
        }

        this.schoolMapper.updateEntityFromDto(updateSchoolDto,schoolEntity);
        return this.schoolMapper.schoolToDto(this.jpaSchoolRepository.save(schoolEntity));
    }

    public void deleteById(long id) {
        SchoolEntity schoolEntity=this.jpaSchoolRepository.findById(id).orElse(null);
        if(schoolEntity==null) {
            throw new RuntimeException("School not founded");
        }
        this.jpaSchoolRepository.delete(schoolEntity);
        System.out.println("School Entity"+schoolEntity.toString()+"Deleted");
    }

}
