package com.education.rural.domain.service.Academic.AcademicAssignment;

import com.education.rural.domain.dto.Academic.academicAssignment.AcademicAssignmentDto;
import com.education.rural.domain.dto.Academic.academicAssignment.UpdateAcademicAssignmentDto;
import com.education.rural.domain.repository.Academic.AcademicAssignment.AcademicAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicAssignmentService implements IAcademicAssignmentService {
    private final AcademicAssignmentRepository academicAssignmentRepository;

    public AcademicAssignmentService(AcademicAssignmentRepository academicAssignmentRepository) {
        this.academicAssignmentRepository = academicAssignmentRepository;
    }

    @Override
    public List<AcademicAssignmentDto> findAll() {
        return this.academicAssignmentRepository.findall();
    }

    @Override
    public AcademicAssignmentDto findById(Integer id) {
        return this.academicAssignmentRepository.findById(id);
    }

    @Override
    public AcademicAssignmentDto save(AcademicAssignmentDto academicAssignmentDto) {
        return this.academicAssignmentRepository.save(academicAssignmentDto);
    }

    @Override
    public AcademicAssignmentDto update(Integer id, UpdateAcademicAssignmentDto updateAcademicAssignmentDto) {
        return this.academicAssignmentRepository.update(id, updateAcademicAssignmentDto);
    }

    @Override
    public void deleteById(Integer id) {
        this.academicAssignmentRepository.deleteById(id);
        System.out.println("academicAssignment with id " + id + " deleted");
    }
}
