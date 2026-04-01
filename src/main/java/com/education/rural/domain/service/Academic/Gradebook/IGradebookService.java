package com.education.rural.domain.service.Academic.Gradebook;

import com.education.rural.domain.dto.Academic.Gradebook.GradebookDto;
import com.education.rural.domain.dto.Academic.Gradebook.UpdateGradebookDto;

import java.util.List;

public interface IGradebookService {

    List<GradebookDto> findAll();
    GradebookDto findById(int id);
    GradebookDto save(GradebookDto gradebookDto);
    GradebookDto patch(Integer id, UpdateGradebookDto updateGradebookDto);
    void delete(Integer id);
}
