package com.education.rural.domain.service.school;

import com.education.rural.domain.dto.school.SchoolDto;
import com.education.rural.domain.dto.school.UpdateSchoolDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ISchoolService {

    List<SchoolDto> findAllSchool();
    SchoolDto getSchoolById(long schoolId);
    SchoolDto addSchool(SchoolDto schoolDto);


    SchoolDto updateSchool(@Valid long schoolId,@Valid UpdateSchoolDto updateSchoolDto);
    void deleteSchool(@Valid long schoolId);
}
