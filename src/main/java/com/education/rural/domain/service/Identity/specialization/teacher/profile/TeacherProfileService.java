package com.education.rural.domain.service.Identity.specialization.teacher.profile;


import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherProfileDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherProfileService implements ITeacherProfileService {

    private final TeacherProfileRepository teacherProfileRepository;

    public TeacherProfileService(TeacherProfileRepository teacherProfileRepository) {
        this.teacherProfileRepository = teacherProfileRepository;
    }

    @Override
    public List<TeacherProfileDto> findAll() {
        return this.teacherProfileRepository.findAll();
    }

    @Override
    public TeacherProfileDto findById(Integer id) {
        return this.teacherProfileRepository.findById(id);
    }

    @Override
    public TeacherProfileDto findByProfileName(String profileName) {
        return this.teacherProfileRepository.findFirstByProfileNameIgnoreCase(profileName);
    }

    @Override
    public TeacherProfileDto saveProfile(TeacherProfileDto teacherProfileDto) {
        return this.teacherProfileRepository.save(teacherProfileDto);
    }

    @Override
    public TeacherProfileDto updateProfile(Integer id, UpdateTeacherProfileDto updateTeacherProfileDto) {
        return this.teacherProfileRepository.patch(id, updateTeacherProfileDto);
    }

    @Override
    public void deleteTeacherProfileByid(Integer id) {
        this.teacherProfileRepository.delete(id);
    }
}
