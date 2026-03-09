package com.education.rural.domain.service;

import com.education.rural.domain.dto.CampusDto;

import java.util.List;

public interface ICampusService {


    List<CampusDto> findAllCampus();
    CampusDto findCampusById(Integer id);
    CampusDto findCampusByName(String name);
    CampusDto saveCampus(CampusDto campusDto);
    CampusDto updateCampus(int id,CampusDto campusDto);
    void deleteCampus(Integer id);
}
