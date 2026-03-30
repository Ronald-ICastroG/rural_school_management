package com.education.rural.persistence.repository.Identity.specialization.teacher.profile;

import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherProfileDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherProfileRepository;
import com.education.rural.persistence.entity.Identity.specialization.TeacherProfileEntity;
import com.education.rural.persistence.mapper.Identity.specialization.TeacherProfileMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherProfileEntityRepository implements TeacherProfileRepository {

private final JpaTeacherProfileRepository jpaTeacherProfileRepository;
private final TeacherProfileMapper teacherProfileMapper;

    public TeacherProfileEntityRepository(JpaTeacherProfileRepository jpaTeacherRepository, TeacherProfileMapper teacherProfileMapper) {
        this.jpaTeacherProfileRepository = jpaTeacherRepository;
        this.teacherProfileMapper = teacherProfileMapper;
    }


    @Override
    public List<TeacherProfileDto> findAll() {
        return this.teacherProfileMapper.toDtos(this.jpaTeacherProfileRepository.findAll());
    }

    @Override
    public TeacherProfileDto findById(Integer id) {
        return this.teacherProfileMapper.toDto(this.jpaTeacherProfileRepository.findById(id).orElseThrow(()->new RuntimeException("TeacherProfileId not found")));
    }

    @Override
    public TeacherProfileDto findFirstByProfileNameIgnoreCase(String profileName) {
        return this.teacherProfileMapper.toDto(this.jpaTeacherProfileRepository.findFirstByProfileNameIgnoreCase(profileName));
    }

    @Override
    public TeacherProfileDto save(TeacherProfileDto teacherProfileDto) {
        TeacherProfileEntity teacherProfileEntity = this.teacherProfileMapper.toEntity(teacherProfileDto);
        TeacherProfileEntity savedProfile = this.jpaTeacherProfileRepository.save(teacherProfileEntity);
        return this.teacherProfileMapper.toDto(savedProfile);
    }

    @Override
    public TeacherProfileDto patch(Integer id, UpdateTeacherProfileDto updateTeacherProfileDto) {
        TeacherProfileEntity profileEntity=this.jpaTeacherProfileRepository.findById(id).orElseThrow(()->new RuntimeException("ProfileId not found"));
        this.teacherProfileMapper.updateTeacherToDto(updateTeacherProfileDto,profileEntity);
        return this.teacherProfileMapper.toDto(this.jpaTeacherProfileRepository.save(profileEntity));
    }

    @Override
    public void delete(Integer id) {
        TeacherProfileEntity profileEntity=this.jpaTeacherProfileRepository.findById(id).orElseThrow(()->new RuntimeException("ProfileId not found"));
        this.jpaTeacherProfileRepository.deleteById(id);
        System.out.println("Teachers profile with id"+ id+" has been deleted ");
    }


}
