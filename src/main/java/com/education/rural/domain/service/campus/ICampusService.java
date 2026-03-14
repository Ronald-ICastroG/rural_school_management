package com.education.rural.domain.service.campus;

import com.education.rural.domain.dto.campus.CampusDto;
import com.education.rural.domain.dto.campus.UpdateCampusDto;

import java.util.List;

public interface ICampusService {


    List<CampusDto> findAllCampus();
    CampusDto findCampusById(Integer id);
    CampusDto findCampusByName(String name);
    CampusDto saveCampus(CampusDto campusDto);
    CampusDto patchCampus(int id, UpdateCampusDto updateCampusDto);
    void deleteCampus(Integer id);
}
