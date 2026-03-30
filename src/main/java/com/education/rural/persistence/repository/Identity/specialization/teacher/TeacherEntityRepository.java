package com.education.rural.persistence.repository.Identity.specialization.teacher;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherRepository;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Identity.specialization.TeacherEntity;
import com.education.rural.persistence.entity.Identity.specialization.TeacherProfileEntity;
import com.education.rural.persistence.mapper.Identity.specialization.TeacherMapper;
import com.education.rural.persistence.repository.Identity.person.JpaPersonRepository;
import com.education.rural.persistence.repository.Identity.specialization.teacher.profile.JpaTeacherProfileRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherEntityRepository implements TeacherRepository {

    private final TeacherMapper teacherMapper;
    private final JpaTeacherRepository jpaTeacherRepository;
    private final JpaPersonRepository jpaPersonRepository;
    private final JpaTeacherProfileRepository jpaTeacherProfileRepository;

    public TeacherEntityRepository(TeacherMapper teacherMapper, JpaTeacherRepository jpaTeacherRepository, JpaPersonRepository jpaPersonRepository, JpaTeacherProfileRepository jpaTeacherProfileRepository) {
        this.teacherMapper = teacherMapper;
        this.jpaTeacherRepository = jpaTeacherRepository;
        this.jpaPersonRepository = jpaPersonRepository;
        this.jpaTeacherProfileRepository = jpaTeacherProfileRepository;
    }

    @Override
    public List<TeacherDto> findAllTeachers() {
        return this.teacherMapper.teachersToDto(this.jpaTeacherRepository.findAll());
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        return this.teacherMapper.toDto(this.jpaTeacherRepository
                .findById(id).orElseThrow(()->new RuntimeException("teacher not found")));
    }

    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        PersonEntity personEntity=this.jpaPersonRepository.findById(teacherDto.personId()).orElseThrow(()->new RuntimeException("Person id not found"));
        TeacherProfileEntity teacherProfileEntity=this.jpaTeacherProfileRepository.findById(teacherDto.profileId()).orElseThrow(()->new RuntimeException("Teacher profile not found"));
       TeacherEntity teacherEntity=teacherMapper.toEntity(teacherDto);
        teacherEntity.setPersonEntity(personEntity);
        teacherEntity.setTeacherProfileEntity(teacherProfileEntity);
        return this.teacherMapper.toDto(this.jpaTeacherRepository.save(teacherEntity));
    }

    @Override
    public TeacherDto patchTeacher(Integer teacherId, UpdateTeacherDto updateTeacherDto) {
        TeacherEntity teacherEntity=this.jpaTeacherRepository
                .findById(teacherId).orElseThrow(()->new RuntimeException("teacher not found"));
        this.teacherMapper.updateTeacherFromDto(updateTeacherDto,teacherEntity);
        return this.teacherMapper.toDto(this.jpaTeacherRepository.save(teacherEntity));
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        if(this.jpaTeacherRepository.existsById(teacherId)){
            this.jpaTeacherRepository.deleteById(teacherId);
        }


    }
}
