package com.education.rural.domain.repository;

import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.dto.UpdateSchoolDto;

import java.util.List;


public interface SchoolRepository {

    List<SchoolDto> getAll();
    SchoolDto getById(long id);
    SchoolDto save(SchoolDto schoolDto);
    SchoolDto update(long id, UpdateSchoolDto updateSchoolDto);
    void deleteById(long id);
}
