package com.education.rural.domain.service.Institutional.grade;

import com.education.rural.domain.dto.institutional.grade.GradeDto;
import com.education.rural.domain.dto.institutional.grade.UpdateGradeDto;

import java.util.List;

public interface IGradeService {

    List<GradeDto> findAllCampus();
    GradeDto findById(Integer id);
    GradeDto findByGradeNameIgnoreCase(String name);
    GradeDto patchGrade(int id, UpdateGradeDto updateGradeDto);
    GradeDto saveGrade(GradeDto grade);
    void deleteGrade(int id);
}
