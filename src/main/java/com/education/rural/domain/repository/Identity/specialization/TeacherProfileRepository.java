package com.education.rural.domain.repository.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherProfileDto;

import java.util.List;

public interface TeacherProfileRepository {

    List<TeacherProfileDto> findAll();

    TeacherProfileDto findById(Integer id);

    TeacherProfileDto findFirstByProfileNameIgnoreCase(String profileName);

    TeacherProfileDto save(TeacherProfileDto teacherProfileDto);

    TeacherProfileDto patch(Integer id, UpdateTeacherProfileDto updateTeacherProfileDto);

    void delete(Integer id);
}
