package com.education.rural.persistence.repository.Institutional.campus;

import com.education.rural.domain.dto.institutional.campus.CampusDto;
import com.education.rural.domain.dto.institutional.campus.UpdateCampusDto;
import com.education.rural.domain.repository.Institutional.CampusRepository;
import com.education.rural.persistence.entity.Institutional.CampusEntity;
import com.education.rural.persistence.mapper.Institutional.CampusMapper;
import jakarta.transaction.Transactional;
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


//    @Override
//    @Transactional
//    public CampusDto patch(int id, UpdateCampusDto updateCampusDto) {
//        //Valido
//        CampusEntity campusEntity=this.jpaCampusRepository.findById(id).orElseThrow(()->new RuntimeException("Campus not found"));
//
//
//        //uso el dto con mappingTarget para cambiar solos campos que quiero en el dto
////        if(updateCampusDto.campusName() != null) campusEntity.setCampusName(updateCampusDto.campusName());
////        if(updateCampusDto.campusLocation() != null) campusEntity.setCampusLocation(updateCampusDto.campusLocation());
////        if(updateCampusDto.campusActive() != null) campusEntity.setCampusActive(updateCampusDto.campusActive());
////
////        //guarda el patchGrade con lo necesario
////        System.out.println("ID Escuela: " + campusEntity.getSchool().getEscId());
//                this.campusMapper.UpdateCampusFromDto(updateCampusDto, campusEntity);
//        return this.campusMapper.toDto((this.jpaCampusRepository.save(campusEntity)));
//    }

@Override
@Transactional
public CampusDto patch(int id, UpdateCampusDto updateCampusDto) {
    CampusEntity campusEntity = this.jpaCampusRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Campus not found"));

    // Bypassa el mapper completamente para probar
    if (updateCampusDto.campusName() != null)
        campusEntity.setCampusName(updateCampusDto.campusName());
    if (updateCampusDto.campusLocation() != null)
        campusEntity.setCampusLocation(updateCampusDto.campusLocation());
    if (updateCampusDto.campusActive() != null)
        campusEntity.setCampusActive(updateCampusDto.campusActive());

    // El school NO se toca
    System.out.println("School antes de save: " + campusEntity.getSchool());
    System.out.println("Campus ID: " + campusEntity.getCampusId());

    return this.campusMapper.toDto(this.jpaCampusRepository.save(campusEntity));
}



    @Override
    public void deleteCampus(Integer id) {
        CampusEntity campusEntity=this.jpaCampusRepository.findById(id).orElseThrow(()->new RuntimeException("Campus not found"));

        this.jpaCampusRepository.deleteById(id);
        System.out.println("Campus "+campusEntity.toString()+" has been deleted");

    }
}
