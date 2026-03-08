package com.education.rural.persistence.mapper;


import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.dto.UpdateSchoolDto;
import com.education.rural.persistence.entity.SchoolEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {


    SchoolDto schoolToDto(SchoolEntity entity);

    List<SchoolDto> schoolToDto(Iterable<SchoolEntity> entity);


    @InheritInverseConfiguration
    SchoolEntity dtoToEntity(SchoolDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UpdateSchoolDto dto, @MappingTarget SchoolEntity entity);


}


