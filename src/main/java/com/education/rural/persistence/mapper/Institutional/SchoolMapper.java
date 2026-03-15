package com.education.rural.persistence.mapper.Institutional;


import com.education.rural.domain.dto.institutional.school.SchoolDto;
import com.education.rural.domain.dto.institutional.school.UpdateSchoolDto;
import com.education.rural.persistence.entity.Institutional.SchoolEntity;
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


