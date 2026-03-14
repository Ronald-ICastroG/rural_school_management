package com.education.rural.persistence.repository.grade;

import com.education.rural.domain.dto.grade.GradeDto;
import com.education.rural.domain.dto.grade.UpdateGradeDto;
import com.education.rural.domain.repository.GradeRepository;
import com.education.rural.persistence.entity.CampusEntity;
import com.education.rural.persistence.entity.GradeEntity;
import com.education.rural.persistence.mapper.GradeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeEntityRepository implements GradeRepository {

    private final JpaGradeRepository jpaGradeRepository;
    private final GradeMapper gradeMapper;

    public GradeEntityRepository(JpaGradeRepository jpaGradeRepository, GradeMapper gradeMapper) {
        this.jpaGradeRepository = jpaGradeRepository;
        this.gradeMapper = gradeMapper;
    }

    @Override
    public List<GradeDto> findAll() {
        return this.gradeMapper.toGradeDto(this.jpaGradeRepository.findAll());
    }

    @Override
    public GradeDto findById(Integer id) {
        return this.gradeMapper.toGradeDto(this.jpaGradeRepository.findById(id).orElse(null));
    }

    @Override
    public GradeDto findByName(String name) {
        GradeEntity gradeEntity=this.jpaGradeRepository.findFirstByGradeNameIgnoreCase(name);
        return (gradeEntity!=null)? this.gradeMapper.toGradeDto(gradeEntity) : null;
    }

    @Override
    public GradeDto save(GradeDto gradeDto) {
        GradeEntity gradeEntity=gradeMapper.toGradeEntity(gradeDto);
        GradeEntity gradeSaved=this.jpaGradeRepository.save(gradeEntity);
        return this.gradeMapper.toGradeDto(gradeSaved);
    }




    @Override
    public GradeDto patchGrade(int id, UpdateGradeDto updateGradeDto) {
        GradeEntity gradeEntity=this.jpaGradeRepository.findById(id).
                orElseThrow(()->new RuntimeException("grade not found"));
        if(updateGradeDto.gradeName()!=null) gradeEntity.setGradeName(updateGradeDto.gradeName());
        if(updateGradeDto.gradeActive()!=null)gradeEntity.setGradeActive(updateGradeDto.gradeActive());
        this.gradeMapper.updateGradeFromDto(updateGradeDto, gradeEntity);
        return this.gradeMapper.toGradeDto(this.jpaGradeRepository.save(gradeEntity));
    }

    @Override
    public void delete(Integer id) {
        GradeEntity gradeEntity=this.jpaGradeRepository.findById(id).orElse(null);
        this.jpaGradeRepository.delete(gradeEntity);
        System.out.println("grade "+gradeEntity.toString()+" deleted");

    }
}
