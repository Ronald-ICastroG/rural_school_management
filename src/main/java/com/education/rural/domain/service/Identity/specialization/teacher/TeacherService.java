package com.education.rural.domain.service.Identity.specialization.teacher;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService{
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;

    }

    @Override
    public Page<TeacherDto> findActiveTeachers(Pageable pageable) {
        return this.teacherRepository.findActiveTeachers(pageable);
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
