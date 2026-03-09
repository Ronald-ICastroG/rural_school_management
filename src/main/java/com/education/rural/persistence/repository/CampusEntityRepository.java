package com.education.rural.persistence.repository;

import com.education.rural.domain.dto.CampusDto;
import com.education.rural.domain.repository.CampusRepository;
import com.education.rural.persistence.entity.CampusEntity;
import com.education.rural.persistence.mapper.CampusMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampusEntityRepository implements CampusRepository {

    private final JpaCampusRepository jpaCampusRepository;
    private final CampusMapper campusMapper;

    public CampusEntityRepository(JpaCampusRepository jpaCampusRepository, CampusMapper campusMapper) {
        this.jpaCampusRepository = jpaCampusRepository;
        this.campusMapper = campusMapper;
    }


        public List<CampusDto>findAllCampus() {
        return this.campusMapper.toDto(this.jpaCampusRepository.findAll());
    }



    @Override
    public CampusDto findCampusById(Integer id) {
        return this.campusMapper.toDto(this.jpaCampusRepository.findById(id).orElse(null));
    }

    @Override
    public CampusDto findFirstByNameCampusIgnoreCase(String campusName) {
        CampusEntity campusEntity=this.jpaCampusRepository.findFirstByCampusNameIgnoreCase(campusName);
        return(campusEntity!=null)? this.campusMapper.toDto(campusEntity):null;
    }

    @Override
    public CampusDto save(CampusDto campusDto) {
        CampusEntity campusEntity=this.campusMapper.toEntity(campusDto);
        CampusEntity savedEntity=jpaCampusRepository.save(campusEntity);
            return this.campusMapper.toDto(savedEntity);


        }


    @Override
    public CampusDto update(int id, CampusDto campusDto) {
        CampusEntity campusEntity=this.jpaCampusRepository.findById(id).orElse(null);
        if(campusEntity==null) {
            throw new RuntimeException("Campus not found");
        }
        return this.campusMapper.toDto(this.jpaCampusRepository.save(campusMapper.toEntity(campusDto)));
    }

    @Override
    public void deleteCampus(Integer id) {
        CampusEntity campusEntity=this.jpaCampusRepository.findById(id).orElse(null);
        if(campusEntity==null) {
            throw new RuntimeException("Campus not found");
        }
        this.jpaCampusRepository.deleteById(id);
        System.out.println("Campus "+campusEntity.toString()+" has been deleted");

    }
}
