package com.education.rural.domain.service.grade;

import com.education.rural.domain.dto.grade.GradeDto;
import com.education.rural.domain.dto.grade.UpdateGradeDto;
import com.education.rural.domain.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService implements IGradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<GradeDto> findAllCampus() {
        return this.gradeRepository.findAll();
    }

    @Override
    public GradeDto findById(Integer id) {
        return this.gradeRepository.findById(id);
    }

    @Override
    public GradeDto findByGradeNameIgnoreCase(String name) {
        return this.gradeRepository.findByName(name);
    }

    @Override
    public GradeDto patchGrade(int id, UpdateGradeDto updateGradeDto) {
        return this.gradeRepository.patchGrade(id,updateGradeDto);
    }

    @Override
    public GradeDto saveGrade(GradeDto grade) {
        return this.gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(int id) {
        this.gradeRepository.delete(id);

    }
}
