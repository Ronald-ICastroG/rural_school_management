package com.education.rural.persistence.mapper.Academic.Gradebook;

import com.education.rural.domain.dto.Academic.Gradebook.GradebookDto;
import com.education.rural.domain.dto.Academic.Gradebook.UpdateGradebookDto;
import com.education.rural.persistence.entity.Academic.GradebookEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeBookMapper {

    List<GradebookDto> GradesToDto(Iterable<GradebookEntity>gradebookEntities);

    @Mapping(source = "studentId",target ="studentEntity.studentId")
    @Mapping(source = "assignmentId",target="assignmentEntity.assignmentId")
    GradebookEntity dtoToEntity(GradebookDto gradebookDto);

    @Mapping(source="studentEntity.studentId",target="studentId")
    @Mapping(source ="assignmentEntity.assignmentId",target="assignmentId")
    GradebookDto GradesToDto(GradebookEntity gradebookEntity);


    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target ="studentEntity.studentId",ignore = true)
    @Mapping(target="assignmentEntity.assignmentId",ignore = true)
    void UpdateGradebookFromDto(UpdateGradebookDto updateGradeBookDto, @MappingTarget GradebookEntity gradebookEntity);

}
