package com.education.rural.domain.service.school;

import com.education.rural.domain.dto.school.SchoolDto;
import com.education.rural.domain.dto.school.UpdateSchoolDto;
import com.education.rural.domain.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {
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

    public SchoolDto updateSchool(long id, UpdateSchoolDto updateSchoolDto) {
            return this.schoolRepository.update(id,updateSchoolDto);
    }

    public void deleteSchool(long schoolId) {
        this.schoolRepository.deleteById(schoolId);
    }
}
