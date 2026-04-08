package com.education.rural.domain.service.Identity.specialization.teacher;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITeacherService {

    Page<TeacherDto> findActiveTeachers(Pageable pageable);

    List<TeacherDto> findTeachers();
    TeacherDto getTeacherById(Integer teacherId);
    TeacherDto saveTeacher(TeacherDto teacherDto);
    TeacherDto patchTeacher(Integer id, UpdateTeacherDto updateTeacherDto);
    void deleteTeacher(Integer id);
}
