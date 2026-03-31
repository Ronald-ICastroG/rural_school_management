package com.education.rural.persistence.mapper.Academic.Assignment;


import com.education.rural.domain.dto.Academic.academicAssignment.AcademicAssignmentDto;
import com.education.rural.domain.dto.Academic.academicAssignment.UpdateAcademicAssignmentDto;
import com.education.rural.persistence.entity.Academic.AcademicAssignmentEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AcademicAssigmnentMapper {

    List<AcademicAssignmentDto> ToDtos(Iterable<AcademicAssignmentEntity> entities);


    @InheritInverseConfiguration
    AcademicAssignmentDto toDto(AcademicAssignmentEntity entity);

    AcademicAssignmentEntity toEntity(AcademicAssignmentDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void UpdateAcademicAssignmentFromDto(UpdateAcademicAssignmentDto dto,@MappingTarget AcademicAssignmentEntity entity);
}
