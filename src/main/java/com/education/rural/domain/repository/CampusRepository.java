package com.education.rural.domain.repository;

import com.education.rural.domain.dto.campus.CampusDto;
import com.education.rural.domain.dto.campus.UpdateCampusDto;

import java.util.List;

public interface CampusRepository {

    List<CampusDto> findAllCampus();
    CampusDto findCampusById(Integer id);

    CampusDto findFirstByNameCampusIgnoreCase(String campusName);
    CampusDto save(CampusDto campusDto);
    CampusDto patch(int id, UpdateCampusDto updateCampusDto);
    void deleteCampus(Integer id);



}
