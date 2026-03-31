package com.education.rural.domain.service.Identity.specialization.teacher;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;

import java.util.List;

public interface ITeacherService {

    List<TeacherDto> findTeachers();
    TeacherDto getTeacherById(Integer teacherId);
    TeacherDto saveTeacher(TeacherDto teacherDto);
    TeacherDto patchTeacher(Integer id, UpdateTeacherDto updateTeacherDto);
    void deleteTeacher(Integer id);
}
