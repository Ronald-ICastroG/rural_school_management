package com.education.rural.persistence.mapper.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.student.StudentDto;
import com.education.rural.domain.dto.Identity.specialization.student.UpdateStudentDto;
import com.education.rural.persistence.entity.Identity.specialization.StudentEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<StudentDto> toStudentEntity(Iterable<StudentEntity> studentEntities);




    @Mapping(target ="person.personId",source="personId" )
    @Mapping(target ="grade.gradeId",source="gradeId" )
    StudentEntity toStudentEntity(StudentDto studentDto);


    @Mapping(target= "personId",source = "person.personId")
    @Mapping(target="gradeId",source = "grade.gradeId")
    StudentDto toStudentDto(StudentEntity studentEntity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target= "person.personId",ignore = true)
    @Mapping(target="grade.gradeId",ignore = true)
    void UpdateStudentFromDto(UpdateStudentDto updateStudentDto,@MappingTarget StudentEntity studentEntity);
}
