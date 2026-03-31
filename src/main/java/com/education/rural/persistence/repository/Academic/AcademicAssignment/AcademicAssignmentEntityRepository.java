package com.education.rural.persistence.repository.Academic.AcademicAssignment;

import com.education.rural.domain.dto.Academic.academicAssignment.AcademicAssignmentDto;
import com.education.rural.domain.dto.Academic.academicAssignment.UpdateAcademicAssignmentDto;
import com.education.rural.domain.repository.Academic.AcademicAssignment.AcademicAssignmentRepository;
import com.education.rural.persistence.entity.Academic.AcademicAssignmentEntity;
import com.education.rural.persistence.mapper.Academic.Assignment.AcademicAssigmnentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AcademicAssignmentEntityRepository implements AcademicAssignmentRepository {

        private final AcademicAssigmnentMapper academicAssigmnentMapper;
        private final JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository;

    public AcademicAssignmentEntityRepository(AcademicAssigmnentMapper academicAssigmnentMapper, JpaAcademicAssignmentRepository jpaAcademicAssignmentRepository) {
        this.academicAssigmnentMapper = academicAssigmnentMapper;
        this.jpaAcademicAssignmentRepository = jpaAcademicAssignmentRepository;
    }


    @Override
    public List<AcademicAssignmentDto> findall() {
        return this.academicAssigmnentMapper.ToDtos(this.jpaAcademicAssignmentRepository.findAll());
    }

    @Override
    public AcademicAssignmentDto findById(Integer id) {
        return this.academicAssigmnentMapper.toDto(this.jpaAcademicAssignmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Academic assignment not found!")));
    }

    @Override
    public AcademicAssignmentDto save(AcademicAssignmentDto academicAssignmentDto) {
        AcademicAssignmentEntity academicAssignmentEntity=this.academicAssigmnentMapper.toEntity(academicAssignmentDto);
        return  this.academicAssigmnentMapper.toDto(this.jpaAcademicAssignmentRepository.save(academicAssignmentEntity));
    }

    @Override
    public AcademicAssignmentDto update(Integer id, UpdateAcademicAssignmentDto updateAcademicAssignmentDto) {
        AcademicAssignmentEntity academicAssignmentEntity=this.jpaAcademicAssignmentRepository.getById(id);
        this.academicAssigmnentMapper.UpdateAcademicAssignmentFromDto(updateAcademicAssignmentDto,academicAssignmentEntity);

        return this.academicAssigmnentMapper.toDto(this.jpaAcademicAssignmentRepository.save(academicAssignmentEntity));
    }

    @Override
    public void deleteById(Integer id) {
        if(this.jpaAcademicAssignmentRepository.existsById(id)){
            this.jpaAcademicAssignmentRepository.deleteById(id);
        }

    }
}
