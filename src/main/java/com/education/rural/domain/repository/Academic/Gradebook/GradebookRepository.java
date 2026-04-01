package com.education.rural.domain.repository.Academic.Gradebook;

import com.education.rural.domain.dto.Academic.Gradebook.GradebookDto;
import com.education.rural.domain.dto.Academic.Gradebook.UpdateGradebookDto;

import java.util.List;

public interface GradebookRepository {

    List<GradebookDto> findAll();
    GradebookDto findById(Integer id);
    GradebookDto save(GradebookDto gradebookDto);
    GradebookDto patchGradeBook(Integer id, UpdateGradebookDto updateGradeBookDto);
    void deleteById(Integer id);
}
