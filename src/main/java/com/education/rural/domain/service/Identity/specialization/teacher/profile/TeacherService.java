package com.education.rural.domain.service.Identity.specialization.teacher.profile;

import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherRepository;
import com.education.rural.persistence.repository.Identity.specialization.teacher.JpaTeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService{
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;

    }

    @Override
    public List<TeacherDto> findTeachers() {
        return this.teacherRepository.findAllTeachers();
    }

    @Override
    public TeacherDto getTeacherById(Integer teacherId) {
        return this.teacherRepository.getTeacherById(teacherId);
    }

    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        return this.teacherRepository.saveTeacher(teacherDto);
    }

    @Override
    public TeacherDto patchTeacher(Integer id, UpdateTeacherDto updateTeacherDto) {
        return this.teacherRepository.patchTeacher(id,updateTeacherDto);
    }

    @Override
    public void deleteTeacher(Integer id) {
        this.teacherRepository.deleteTeacher(id);
        System.out.println("teacher with id "+ id+" deleted successfully");

    }
}
