package com.education.rural.domain.service;

import com.education.rural.domain.dto.CampusDto;
import com.education.rural.domain.dto.UpdateCampusDto;

import java.util.List;

public interface ICampusService {


    List<CampusDto> findAllCampus();
    CampusDto findCampusById(Integer id);
    CampusDto findCampusByName(String name);
    CampusDto saveCampus(CampusDto campusDto);
    CampusDto patchCampus(int id, UpdateCampusDto updateCampusDto);
    void deleteCampus(Integer id);
}
