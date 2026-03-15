package com.education.rural.domain.repository.Institutional;

import com.education.rural.domain.dto.institutional.campus.CampusDto;
import com.education.rural.domain.dto.institutional.campus.UpdateCampusDto;

import java.util.List;

public interface CampusRepository {

    List<CampusDto> findAllCampus();
    CampusDto findCampusById(Integer id);

    CampusDto findFirstByNameCampusIgnoreCase(String campusName);
    CampusDto save(CampusDto campusDto);
    CampusDto patch(int id, UpdateCampusDto updateCampusDto);
    void deleteCampus(Integer id);



}
