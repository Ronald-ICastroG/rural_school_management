package com.education.rural.domain.repository.Institutional;

import com.education.rural.domain.dto.institutional.grade.GradeDto;
import com.education.rural.domain.dto.institutional.grade.UpdateGradeDto;

import java.util.List;

public interface GradeRepository {
    List<GradeDto> findAll();
    GradeDto findById(Integer id);
    GradeDto findByName(String name);
    GradeDto save(GradeDto gradeDto);
    GradeDto patchGrade(int id, UpdateGradeDto updateGradeDto);
    void delete(Integer id);
}
