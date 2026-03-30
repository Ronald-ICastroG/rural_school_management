package com.education.rural.domain.repository.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.student.StudentDto;
import com.education.rural.domain.dto.Identity.specialization.student.UpdateStudentDto;

import java.util.List;

public interface StudentRepository {

    List<StudentDto> findAllStudents();
    StudentDto findStudentById(Integer id);
    StudentDto saveStudent(StudentDto studentDto);
    StudentDto patchStudent(Integer id, UpdateStudentDto updateStudentDto);
    void deleteStudentById(Integer id);

}
