package com.education.rural.domain.repository;

import com.education.rural.domain.dto.CampusDto;

import java.util.List;

public interface CampusRepository {

    List<CampusDto> findAllCampus();
    CampusDto findCampusById(Integer id);

    CampusDto findFirstByNameCampusIgnoreCase(String campusName);
    CampusDto save(CampusDto campusDto);
    CampusDto update(int id,CampusDto campusDto);
    void deleteCampus(Integer id);



}
