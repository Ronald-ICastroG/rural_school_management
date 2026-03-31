package com.education.rural.persistence.mapper.Identity.specialization;


import com.education.rural.domain.dto.Identity.specialization.staff.StaffDto;
import com.education.rural.domain.dto.Identity.specialization.staff.UpdateStaffDto;
import com.education.rural.persistence.entity.Identity.specialization.StaffEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {


    List<StaffDto> StaffsToDto(Iterable<StaffEntity> staffEntities);

    @Mapping(target = "staffId", source = "staffId")
    @Mapping(source="personEntity.personId",target="personId")
    @Mapping(source="schoolEntity.escId",target= "escId")
    @Mapping(source="campusEntity.campusId",target="campusId")
    StaffDto StaffsToDto(StaffEntity staffEntity);

    @Mapping(target="personEntity",ignore = true)
    @Mapping(target="schoolEntity",ignore = true)
    @Mapping(target="campusEntity",ignore = true)
    StaffEntity StaffToEntity(StaffDto staffDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="personEntity.personId",ignore = true)
    @Mapping(target="schoolEntity.escId",ignore = true)
    @Mapping(target="campusEntity.campusId",ignore = true)
    void updateStaffFromDto(UpdateStaffDto updateStaffDto, @MappingTarget StaffEntity staffEntity);
}
