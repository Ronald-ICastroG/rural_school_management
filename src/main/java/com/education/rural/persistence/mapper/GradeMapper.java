package com.education.rural.persistence.mapper;

import com.education.rural.domain.dto.grade.GradeDto;
import com.education.rural.domain.dto.grade.UpdateGradeDto;
import com.education.rural.persistence.entity.GradeEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    List<GradeDto> toGradeDto(Iterable<GradeEntity> gradesEntities);


    @Mapping(target="campus.campusId",source = "campusId")
    GradeEntity toGradeEntity(GradeDto gradeDto);

    @InheritInverseConfiguration
    @Mapping(target="campusId",source = "campus.campusId")
    GradeDto toGradeDto(GradeEntity gradeEntity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gradeId", ignore = true)
    @Mapping(target="campus",ignore = true)
    void updateGradeFromDto(UpdateGradeDto updateGradeDto,@MappingTarget GradeEntity entity);
}
