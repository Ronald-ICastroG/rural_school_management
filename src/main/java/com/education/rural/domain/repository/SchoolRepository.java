package com.education.rural.domain.repository;

import com.education.rural.domain.dto.SchoolDto;

import java.util.List;

public interface SchoolRepository {

    List<SchoolDto> getAll();
    SchoolDto getById(long id);
    SchoolDto save(String name);
}
