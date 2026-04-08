package com.education.rural.persistence.repository.Identity.specialization.teacher;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherRepository;
import com.education.rural.persistence.entity.Academic.AcademicAssignmentEntity;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Identity.specialization.TeacherEntity;
import com.education.rural.persistence.entity.Identity.specialization.TeacherProfileEntity;
import com.education.rural.persistence.mapper.Identity.specialization.TeacherMapper;
import com.education.rural.persistence.repository.Academic.AcademicAssignment.JpaAcademicAssignmentRepository;
import com.education.rural.persistence.repository.Identity.person.JpaPersonRepository;
import com.education.rural.persistence.repository.Identity.specialization.teacher.profile.JpaTeacherProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class TeacherEntityRepository implements TeacherRepository {

    private final TeacherMapper teacherMapper;
    private final JpaTeacherRepository jpaTeacherRepository;
    private final JpaPersonRepository jpaPersonRepository;
    private final JpaTeacherProfileRepository jpaTeacherProfileRepository;
    private final JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository;

    public TeacherEntityRepository(TeacherMapper teacherMapper, JpaTeacherRepository jpaTeacherRepository, JpaPersonRepository jpaPersonRepository, JpaTeacherProfileRepository jpaTeacherProfileRepository, JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository) {
        this.teacherMapper = teacherMapper;
        this.jpaTeacherRepository = jpaTeacherRepository;
        this.jpaPersonRepository = jpaPersonRepository;
        this.jpaTeacherProfileRepository = jpaTeacherProfileRepository;
        this.jpaAcademicAssignmentRepository = jpaAcademicAssignmentRepository;
    }




    @Override
    public List<TeacherDto> findAllTeachers() {
        return this.teacherMapper.teachersToDto(this.jpaTeacherRepository.findAll());
    }

    public Page<TeacherDto> findActiveTeachers(Pageable pageable){
     return this.jpaTeacherRepository.findByTeacherActiveTrue(pageable)
             .map(teacherMapper::toDto);
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        return this.teacherMapper.toDto(this.jpaTeacherRepository
                .findById(id).orElseThrow(()->new RuntimeException("teacher not found")));
    }

    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {


        PersonEntity personEntity=this.jpaPersonRepository.findById(teacherDto.personId()).orElseThrow(()->new RuntimeException("Person id not found"));
        AcademicAssignmentEntity assignmentEntity=this.jpaAcademicAssignmentRepository.findById(teacherDto.assignmentId()).orElseThrow(()->new RuntimeException("Assignment id not found"));
        TeacherProfileEntity teacherProfileEntity=this.jpaTeacherProfileRepository.findById(teacherDto.profileId()).orElseThrow(()->new RuntimeException("Teacher profile not found"));
       TeacherEntity teacherEntity=teacherMapper.toEntity(teacherDto);
       teacherEntity.setAssignmentEntity(assignmentEntity);
        teacherEntity.setPersonEntity(personEntity);
        teacherEntity.setTeacherProfileEntity(teacherProfileEntity);
        return this.teacherMapper.toDto(this.jpaTeacherRepository.save(teacherEntity));
    }

    @Override
    public TeacherDto patchTeacher(Integer teacherId, UpdateTeacherDto updateTeacherDto) {
        TeacherEntity teacherEntity=this.jpaTeacherRepository
                .findById(teacherId).orElseThrow(()->new RuntimeException("teacher not found"));

        if(updateTeacherDto.assignmentId()!=null) {
            AcademicAssignmentEntity assignmentEntity = this.jpaAcademicAssignmentRepository
                    .findById(updateTeacherDto.assignmentId())
                    .orElseThrow(() -> new RuntimeException("Assignment id not found"));
            teacherEntity.setAssignmentEntity(assignmentEntity);
        }
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
