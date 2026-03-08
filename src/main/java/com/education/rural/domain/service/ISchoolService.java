package com.education.rural.domain.service;

import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.dto.UpdateSchoolDto;
import jakarta.validation.Valid;
import org.hibernate.sql.Update;

import java.util.List;

public interface ISchoolService {

    List<SchoolDto> findAllSchool();
    SchoolDto getSchoolById(long schoolId);
    SchoolDto addSchool(SchoolDto schoolDto);


    SchoolDto updateSchool(@Valid long schoolId,@Valid UpdateSchoolDto updateSchoolDto);
    void deleteSchool(@Valid long schoolId);
}
