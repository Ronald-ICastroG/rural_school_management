package com.education.rural.persistence.repository.Academic.Gradebook;

import com.education.rural.domain.dto.Academic.Gradebook.GradebookDto;
import com.education.rural.domain.dto.Academic.Gradebook.UpdateGradebookDto;
import com.education.rural.domain.repository.Academic.Gradebook.GradebookRepository;
import com.education.rural.persistence.entity.Academic.AcademicAssignmentEntity;
import com.education.rural.persistence.entity.Academic.GradebookEntity;
import com.education.rural.persistence.entity.Identity.specialization.StudentEntity;
import com.education.rural.persistence.mapper.Academic.Gradebook.GradeBookMapper;
import com.education.rural.persistence.repository.Academic.AcademicAssignment.JpaAcademicAssignmentRepository;
import com.education.rural.persistence.repository.Identity.specialization.student.JpaStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GradebookEntityRepository implements GradebookRepository {

    private final GradeBookMapper gradeBookMapper;
    private final JpaGradebookRepository jpaGradebookRepository;
    private final JpaStudentRepository jpaStudentRepository;
    private final JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository;

    public GradebookEntityRepository(GradeBookMapper gradeBookMapper, JpaGradebookRepository jpaGradebookRepository, JpaStudentRepository jpaStudentRepository, JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository) {
        this.gradeBookMapper = gradeBookMapper;
        this.jpaGradebookRepository = jpaGradebookRepository;
        this.jpaStudentRepository = jpaStudentRepository;
        this.jpaAcademicAssignmentRepository = jpaAcademicAssignmentRepository;
    }

    @Override
    public List<GradebookDto> findAll() {
        return gradeBookMapper.GradesToDto(jpaGradebookRepository.findAll());
    }

    @Override
    public GradebookDto findById(Integer id) {
        return this.gradeBookMapper.GradesToDto(this.jpaGradebookRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Gradebook not found")));
    }

    @Override
    public GradebookDto save(GradebookDto gradebookDto) {
        StudentEntity studentEntity=this.jpaStudentRepository.findById(gradebookDto.studentId()).orElseThrow(()->new RuntimeException("Student not found"));
        AcademicAssignmentEntity assignmentEntity=this.jpaAcademicAssignmentRepository.findById(gradebookDto.assignmentId()).orElseThrow(()->new RuntimeException("Assignment not found"));
        GradebookEntity gradebookEntity=this.gradeBookMapper.dtoToEntity(gradebookDto);
        gradebookEntity.setAssignmentEntity(assignmentEntity);
        gradebookEntity.setStudentEntity(studentEntity);
        return this.gradeBookMapper.GradesToDto(this.jpaGradebookRepository.save(gradebookEntity));
    }

    @Override
    public GradebookDto patchGradeBook(Integer id, UpdateGradebookDto updateGradeBookDto) {
        GradebookEntity gradebookEntity=this.jpaGradebookRepository.findById(id).orElseThrow(()->new RuntimeException("Gradebook not found"));
        if(updateGradeBookDto.studentId()!=null&&updateGradeBookDto.assignmentId()!=null){
            StudentEntity studentEntity=this.jpaStudentRepository
                    .findById(updateGradeBookDto.studentId()).orElseThrow(()->new RuntimeException("Student not found"));
            AcademicAssignmentEntity assignmentEntity=this.jpaAcademicAssignmentRepository
                    .findById(updateGradeBookDto.assignmentId()).orElseThrow(()->new RuntimeException("Assignment not found"));
            gradebookEntity.setAssignmentEntity(assignmentEntity);
            gradebookEntity.setStudentEntity(studentEntity);
        }
        this.gradeBookMapper.UpdateGradebookFromDto(updateGradeBookDto, gradebookEntity);
        return this.gradeBookMapper.GradesToDto(this.jpaGradebookRepository.save(gradebookEntity));
    }

    @Override
    public void deleteById(Integer id) {
        if(this.jpaGradebookRepository.existsById(id)){
            this.jpaGradebookRepository.deleteById(id);
        }
    }
}
