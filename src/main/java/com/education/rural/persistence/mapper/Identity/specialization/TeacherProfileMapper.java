package com.education.rural.persistence.mapper.Identity.specialization;


import com.education.rural.domain.dto.Identity.specialization.teacher.profile.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.profile.UpdateTeacherProfileDto;
import com.education.rural.persistence.entity.Identity.specialization.TeacherProfileEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherProfileMapper {


    List<TeacherProfileDto> toDtos(Iterable<TeacherProfileEntity> entities);


    TeacherProfileEntity toEntity(TeacherProfileDto dto);

    @InheritInverseConfiguration
    TeacherProfileDto toDto(TeacherProfileEntity entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTeacherToDto(UpdateTeacherProfileDto dto,@MappingTarget TeacherProfileEntity entity);
}
