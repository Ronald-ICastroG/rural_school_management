package com.education.rural.domain.service.Academic.AcademicAssignment;

import com.education.rural.domain.dto.Academic.academicAssignment.AcademicAssignmentDto;
import com.education.rural.domain.dto.Academic.academicAssignment.UpdateAcademicAssignmentDto;

import java.util.List;

public interface IAcademicAssignmentService {

    List<AcademicAssignmentDto> findAll();
    AcademicAssignmentDto findById(Integer id);
    AcademicAssignmentDto save(AcademicAssignmentDto academicAssignmentDto);
    AcademicAssignmentDto update(Integer id,UpdateAcademicAssignmentDto updateAcademicAssignmentDto);
    void deleteById(Integer id);
}
