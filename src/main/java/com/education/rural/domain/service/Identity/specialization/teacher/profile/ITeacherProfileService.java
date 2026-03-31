package com.education.rural.domain.service.Identity.specialization.teacher.profile;

import com.education.rural.domain.dto.Identity.specialization.teacher.profile.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.profile.UpdateTeacherProfileDto;

import java.util.List;

public interface ITeacherProfileService {

    List<TeacherProfileDto> findAllTeacherProfile();
    TeacherProfileDto findTeacherProfileById(Integer id);
    TeacherProfileDto findFirstByProfileNameIgnoreCase(String name);
    TeacherProfileDto saveProfile(TeacherProfileDto teacherProfileDto);
    TeacherProfileDto patchTeacherProfile(Integer id,UpdateTeacherProfileDto updateTeacherProfileDto);
    void deleteTeacherProfileById(Integer id);
}
