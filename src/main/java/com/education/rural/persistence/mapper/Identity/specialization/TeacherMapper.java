package com.education.rural.persistence.mapper.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import com.education.rural.persistence.entity.Identity.specialization.TeacherEntity;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TeacherMapper {


    List<TeacherDto> teachersToDto(Iterable<TeacherEntity> teachers);

    @Mapping(target="personEntity",ignore = true)
    @Mapping(target="teacherProfileEntity", ignore = true)
    @Mapping(target="assignmentEntity",ignore = true)
    TeacherEntity toEntity(TeacherDto teacherDto);

    @Mapping(target ="personId",source="personEntity.personId")
    @Mapping(target = "profileId",source="teacherProfileEntity.profileId")
    @Mapping(target= "assignmentId",source ="assignmentEntity.assignmentId")
    TeacherDto toDto(TeacherEntity teacherEntity);



    @BeanMapping(nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="personEntity.personId",ignore=true)
    @Mapping(target="teacherProfileEntity", ignore = true)
    @Mapping(target="assignmentEntity",ignore = true)
    void updateTeacherFromDto(UpdateTeacherDto updateTeacherDto,
                     @MappingTarget TeacherEntity teacherEntity);
}
