package com.education.rural.domain.service.Identity.specialization.teacher.profile;

import com.education.rural.domain.dto.Identity.specialization.teacher.profile.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.profile.UpdateTeacherProfileDto;

import java.util.List;

public interface ITeacherProfileService {

    List<TeacherProfileDto> findAll();

    TeacherProfileDto findById(Integer id);

    TeacherProfileDto findByProfileName(String profileName);

    TeacherProfileDto saveProfile(TeacherProfileDto teacherProfileDto);

    TeacherProfileDto updateProfile(Integer id, UpdateTeacherProfileDto updateTeacherProfileDto);

    void deleteTeacherProfileByid(Integer id);
}
