package com.education.rural.persistence.mapper.Institutional;

import com.education.rural.domain.dto.institutional.grade.GradeDto;
import com.education.rural.domain.dto.institutional.grade.UpdateGradeDto;
import com.education.rural.persistence.entity.Institutional.GradeEntity;
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
