package com.education.rural.domain.service.Identity.specialization.student;

import com.education.rural.domain.dto.Identity.specialization.student.StudentDto;
import com.education.rural.domain.dto.Identity.specialization.student.UpdateStudentDto;

import java.util.List;

public interface IStudentService {

    List<StudentDto> findAllStudents();
    StudentDto findStudentById(Integer id);
    StudentDto save(StudentDto studentDto);
    StudentDto patchStudent(Integer id, UpdateStudentDto updateStudentDto);
    void deleteStudent(Integer id);

}
