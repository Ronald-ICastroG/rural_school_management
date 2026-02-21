package com.education.rural.domain.repository;

import com.education.rural.domain.dto.SchoolDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SchoolRepository {

    List<SchoolDto> getAll();
    SchoolDto getById(long id);
    SchoolDto save(SchoolDto schoolDto);
}
