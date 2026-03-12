package com.education.rural.domain.service;

import com.education.rural.domain.dto.CampusDto;
import com.education.rural.domain.dto.UpdateCampusDto;
import com.education.rural.domain.repository.CampusRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusService implements ICampusService {

    private final CampusRepository campusRepository;

    public CampusService(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }



    @Override
    public CampusDto findCampusById(Integer id) {
        return this.campusRepository.findCampusById(id);
    }

    @Override
    public CampusDto findCampusByName(String name) {
        return this.campusRepository.findFirstByNameCampusIgnoreCase(name);
    }

    @Override
    public List<CampusDto> findAllCampus() {
        return this.campusRepository.findAllCampus();
    }

    @Override
    public CampusDto saveCampus(CampusDto campusDto) {
        return this.campusRepository.save(campusDto);
    }

    @Override
    public CampusDto patchCampus(int id, UpdateCampusDto updateCampusDto) {
        return this.campusRepository.patch(id,updateCampusDto);
    }

    @Override
    public void deleteCampus(Integer id) {
        this.campusRepository.deleteCampus(id);
    }
}
