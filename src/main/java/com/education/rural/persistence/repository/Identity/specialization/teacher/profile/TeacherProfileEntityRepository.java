package com.education.rural.persistence.repository.Identity.specialization.teacher.profile;

import com.education.rural.domain.dto.Identity.specialization.teacher.profile.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.profile.UpdateTeacherProfileDto;
import com.education.rural.domain.repository.Identity.specialization.TeacherProfileRepository;
import com.education.rural.persistence.entity.Identity.specialization.TeacherProfileEntity;
import com.education.rural.persistence.mapper.Identity.specialization.TeacherProfileMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherProfileEntityRepository implements TeacherProfileRepository {

    private final TeacherProfileMapper teacherProfileMapper;
    private final JpaTeacherProfileRepository jpaTeacherProfileRepository;

    public TeacherProfileEntityRepository(TeacherProfileMapper teacherProfileMapper, JpaTeacherProfileRepository jpaTeacherProfileRepository) {
        this.teacherProfileMapper = teacherProfileMapper;
        this.jpaTeacherProfileRepository = jpaTeacherProfileRepository;
    }

    @Override
    public List<TeacherProfileDto> findAll() {
        return this.teacherProfileMapper.toDtos(jpaTeacherProfileRepository.findAll());
    }

    @Override
    public TeacherProfileDto findById(Integer id) {
        return this.teacherProfileMapper.toDto(jpaTeacherProfileRepository
                .findById(id).orElseThrow(()->new RuntimeException("TeacherProfile Not Found!")));
    }

    @Override
    public TeacherProfileDto findFirstByProfileNameIgnoreCase(String profileName) {
        return this.teacherProfileMapper.toDto(this.jpaTeacherProfileRepository.findFirstByProfileNameIgnoreCase(profileName));

    }

    @Override
    public TeacherProfileDto save(TeacherProfileDto teacherProfileDto) {
        TeacherProfileEntity teacherProfileEntity = teacherProfileMapper.toEntity(teacherProfileDto);
        TeacherProfileEntity savedTeacherProfileEntity = jpaTeacherProfileRepository.save(teacherProfileEntity);
        return this.teacherProfileMapper.toDto(savedTeacherProfileEntity);
    }

    @Override
    public TeacherProfileDto patch(Integer id, UpdateTeacherProfileDto updateTeacherProfileDto) {
        TeacherProfileEntity teacherProfileEntity=this.jpaTeacherProfileRepository.findById(id).orElseThrow(()->new RuntimeException("TeacherProfile Not Found!"));
        this.teacherProfileMapper.updateTeacherToDto(updateTeacherProfileDto,teacherProfileEntity);
        return this.teacherProfileMapper.toDto(teacherProfileEntity);
    }

    @Override
    public void deleteById(Integer id) {
        if (this.jpaTeacherProfileRepository.existsById(id)) {
            this.jpaTeacherProfileRepository.deleteById(id);
        }
    }
}
