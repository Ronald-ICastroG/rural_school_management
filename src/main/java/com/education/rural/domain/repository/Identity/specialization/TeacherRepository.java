package com.education.rural.domain.repository.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;

import java.util.List;

public interface TeacherRepository {


    List<TeacherDto> findAllTeachers();
    TeacherDto getTeacherById(Integer id);
    TeacherDto saveTeacher(TeacherDto teacherDto);
    TeacherDto patchTeacher(Integer teacherId, UpdateTeacherDto updateTeacherDto);
    void deleteTeacher(Integer teacherId);
}
