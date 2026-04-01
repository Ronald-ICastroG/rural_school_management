package com.education.rural.persistence.repository.Academic.Subject;


import com.education.rural.domain.dto.Academic.subject.SubjectDto;
import com.education.rural.domain.dto.Academic.subject.UpdateSubjectDto;
import com.education.rural.domain.repository.Academic.Subject.SubjectRepository;
import com.education.rural.persistence.entity.Academic.AcademicAssignmentEntity;
import com.education.rural.persistence.entity.Academic.SubjectEntity;
import com.education.rural.persistence.mapper.Academic.Subject.SubjectMapper;
import com.education.rural.persistence.repository.Academic.AcademicAssignment.JpaAcademicAssignmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectEntityRepository implements SubjectRepository {

    private final SubjectMapper subjectMapper;
    private final JpaSubjectRepository jpaSubjectRepository;
    private final JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository;

    public SubjectEntityRepository(SubjectMapper subjectMapper, JpaSubjectRepository jpaSubjectRepository, JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository) {
        this.subjectMapper = subjectMapper;
        this.jpaSubjectRepository = jpaSubjectRepository;
        this.jpaAcademicAssignmentRepository = jpaAcademicAssignmentRepository;
    }

    @Override
    public List<SubjectDto> findAll() {
        return this.subjectMapper.subjectsToDto(this.jpaSubjectRepository.findAll());
    }

    @Override
    public SubjectDto findById(Integer id) {

        return this.subjectMapper.EntityToDto(this
                .jpaSubjectRepository.findById(id).orElseThrow(()->new RuntimeException("Subject not found"))) ;
    }

    @Override
    public SubjectDto findFirstBySubjectNameIgnoreCase(String subjectName) {
        return this.subjectMapper.EntityToDto(this.jpaSubjectRepository
                .findFirstBySubjectNameIgnoreCase(subjectName));
    }
    @Override
    public SubjectDto save(SubjectDto subjectDto) {

        AcademicAssignmentEntity assignmentEntity=this.jpaAcademicAssignmentRepository
                .findById(subjectDto.assignmentId()).orElseThrow(()->new RuntimeException("Assignment not found"));
        SubjectEntity subjectEntity=this.subjectMapper.dtoToEntity(subjectDto);
        subjectEntity.setAssignmentEntity(assignmentEntity);
        return this.subjectMapper.EntityToDto(this.jpaSubjectRepository.save(subjectEntity));
    }
    @Override
    public SubjectDto patch(Integer id, UpdateSubjectDto updateSubjectDto) {
            SubjectEntity subjectEntity=this.jpaSubjectRepository
                    .findById(id).orElseThrow(()->new RuntimeException("Subject not found"));
            if(updateSubjectDto.assignmentId()!=null){
                AcademicAssignmentEntity assignmentEntity=this.jpaAcademicAssignmentRepository
                        .findById(updateSubjectDto.assignmentId())
                        .orElseThrow(()->new RuntimeException("assignment not found"));
                        subjectEntity.setAssignmentEntity(assignmentEntity);
            }
            this.subjectMapper.UpdateSubjectFromDto(updateSubjectDto, subjectEntity);


            return this.subjectMapper.EntityToDto(this.jpaSubjectRepository.save(subjectEntity));
    }
    @Override
    public void deleteById(Integer id) {
        if(this.jpaSubjectRepository.existsById(id)){
            this.jpaSubjectRepository.deleteById(id);
        }

    }
    @Override
    public void deleteByName(String name) {
        if(this.jpaSubjectRepository.findFirstBySubjectNameIgnoreCase(name)!=null){
            this.jpaSubjectRepository.deleteBySubjectNameIgnoreCase(name);
        }
    }
}
