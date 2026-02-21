package com.education.rural.persistence.mapper;


import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.persistence.entity.SchoolEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {


    SchoolDto schoolToDto(SchoolEntity entity);
    List<SchoolDto> schoolToDto(Iterable<SchoolEntity> entity);

    @InheritInverseConfiguration
    SchoolEntity dtoToEntity(SchoolDto dto);
}


