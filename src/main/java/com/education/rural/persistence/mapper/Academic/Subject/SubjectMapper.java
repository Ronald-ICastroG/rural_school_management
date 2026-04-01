package com.education.rural.persistence.mapper.Academic.Subject;


import com.education.rural.domain.dto.Academic.subject.SubjectDto;
import com.education.rural.domain.dto.Academic.subject.UpdateSubjectDto;
import com.education.rural.persistence.entity.Academic.SubjectEntity;
import org.mapstruct.*;

import javax.crypto.spec.PSource;
import javax.security.auth.Subject;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {


    List<SubjectDto> subjectsToDto (Iterable<SubjectEntity> subjects);


    @Mapping(source="assignmentId",target="assignmentEntity.assignmentId")
    SubjectEntity dtoToEntity(SubjectDto subjectDto);


    @Mapping(source = "assignmentEntity.assignmentId",target="assignmentId")
    SubjectDto EntityToDto(SubjectEntity subjectEntity);

    @BeanMapping(nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source="assignmentId",target="assignmentEntity.assignmentId")
    void UpdateSubjectFromDto(UpdateSubjectDto updateSubjectDto, @MappingTarget SubjectEntity subjectEntity);

}
