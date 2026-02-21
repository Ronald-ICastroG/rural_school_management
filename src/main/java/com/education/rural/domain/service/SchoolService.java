package com.education.rural.domain.service;

import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService{
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    @Override
    public List<SchoolDto> findAllSchool() {
        return this.schoolRepository.getAll();
    }

    @Override
    public SchoolDto getSchoolById(long schoolId) {
        return this.schoolRepository.getById(schoolId);
    }

    @Override
    public SchoolDto addSchool(SchoolDto schoolDto) {
        return this.schoolRepository.save(schoolDto);
    }
}
