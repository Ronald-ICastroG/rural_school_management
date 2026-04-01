package com.education.rural.domain.service.Academic.Gradebook;

import com.education.rural.domain.dto.Academic.Gradebook.GradebookDto;
import com.education.rural.domain.dto.Academic.Gradebook.UpdateGradebookDto;
import com.education.rural.domain.repository.Academic.Gradebook.GradebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradebookService implements IGradebookService {

    private final GradebookRepository gradebookRepository;

    public GradebookService(GradebookRepository gradebookRepository) {
        this.gradebookRepository = gradebookRepository;
    }

    @Override
    public List<GradebookDto> findAll() {
        return this.gradebookRepository.findAll() ;
    }

    @Override
    public GradebookDto findById(int id) {
        return this.gradebookRepository.findById(id) ;
    }

    @Override
    public GradebookDto save(GradebookDto gradebookDto) {
        return this.gradebookRepository.save(gradebookDto);
    }

    @Override
    public GradebookDto patch(Integer id, UpdateGradebookDto updateGradebookDto) {
        return this.gradebookRepository.patchGradeBook(id, updateGradebookDto);
    }

    @Override
    public void delete(Integer id) {
        this.gradebookRepository.deleteById(id);
        System.out.println("Gradebook with id " + id + " was deleted.");
    }
}
