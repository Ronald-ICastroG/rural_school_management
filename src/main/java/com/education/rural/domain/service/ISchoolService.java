package com.education.rural.domain.service;

import com.education.rural.domain.dto.SchoolDto;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

public interface ISchoolService {

    List<SchoolDto> findAllSchool();
    SchoolDto getSchoolById(long schoolId);
    SchoolDto addSchool(SchoolDto schoolDto);


    SchoolDto updateSchool(@Valid long schoolId,@Valid SchoolDto schoolDto);
}
