package com.education.rural.domain.service.Identity.specialization.teacher.profile;

import com.education.rural.domain.dto.Identity.specialization.teacher.profile.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.profile.UpdateTeacherProfileDto;
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
    public List<TeacherProfileDto> findAllTeacherProfile() {
        return this.teacherProfileRepository.findAll();
    }

    @Override
    public TeacherProfileDto findTeacherProfileById(Integer id) {
        return this.teacherProfileRepository.findById(id);
    }

    @Override
    public TeacherProfileDto findFirstByProfileNameIgnoreCase(String name) {
        return this.teacherProfileRepository.findFirstByProfileNameIgnoreCase(name);
    }

    @Override
    public TeacherProfileDto saveProfile(TeacherProfileDto teacherProfileDto) {
        return this.teacherProfileRepository.save(teacherProfileDto);
    }

    @Override
    public TeacherProfileDto patchTeacherProfile(Integer id,UpdateTeacherProfileDto updateTeacherProfileDto) {
        return this.teacherProfileRepository.patch(id, updateTeacherProfileDto);
    }

    @Override
    public void deleteTeacherProfileById(Integer id) {
        this.teacherProfileRepository.deleteById(id);
        System.out.println("TeacherProfile with Id "+id+" deleted");

    }
}
