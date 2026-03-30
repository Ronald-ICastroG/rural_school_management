package com.education.rural.persistence.repository.Identity.specialization.student;

import com.education.rural.domain.dto.Identity.specialization.student.StudentDto;
import com.education.rural.domain.dto.Identity.specialization.student.UpdateStudentDto;
import com.education.rural.domain.repository.Identity.specialization.StudentRepository;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Identity.specialization.StudentEntity;
import com.education.rural.persistence.entity.Institutional.GradeEntity;
import com.education.rural.persistence.mapper.Identity.specialization.StudentMapper;
import com.education.rural.persistence.repository.Identity.person.JpaPersonRepository;
import com.education.rural.persistence.repository.Institutional.grade.JpaGradeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentEntityRepository implements StudentRepository {

    private final StudentMapper studentMapper;
    private final JpaStudentRepository jpaStudentRepository;
    private final JpaPersonRepository jpaPersonRepository;
    private final JpaGradeRepository jpaGradeRepository;

    public StudentEntityRepository(StudentMapper studentMapper, JpaStudentRepository jpaStudentRepository, JpaPersonRepository jpaPersonRepository, JpaGradeRepository jpaGradeRepository) {
        this.studentMapper = studentMapper;
        this.jpaStudentRepository = jpaStudentRepository;
        this.jpaPersonRepository = jpaPersonRepository;
        this.jpaGradeRepository = jpaGradeRepository;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return this.studentMapper.toStudentEntity(this.jpaStudentRepository.findAll());
    }

    @Override
    public StudentDto findStudentById(Integer id) {
        return this.studentMapper.toStudentDto(this.jpaStudentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("student not found")));
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        PersonEntity personEntity = this.jpaPersonRepository.findById(studentDto.personId())
                .orElseThrow(()-> new RuntimeException("Person id not found"));
        GradeEntity gradeEntity=this.jpaGradeRepository.findById(studentDto.gradeId())
                .orElseThrow(()->new RuntimeException("GradeId not found"));

        StudentEntity studentEntity=this.studentMapper.toStudentEntity(studentDto);
        return this.studentMapper.toStudentDto(this.jpaStudentRepository.save(studentEntity));
    }

    @Override
    public StudentDto patchStudent(Integer id, UpdateStudentDto updateStudentDto) {
        StudentEntity studentEntity=this.jpaStudentRepository
                .findById(id).orElseThrow(()-> new RuntimeException("student not found"));
        this.studentMapper.UpdateStudentFromDto(updateStudentDto, studentEntity);
        return this.studentMapper.toStudentDto(this.jpaStudentRepository.save(studentEntity)) ;
    }

    @Override
    public void deleteStudentById(Integer id) {
        StudentEntity studentEntity=this.jpaStudentRepository
                .findById(id).orElseThrow(()-> new RuntimeException("student not found"));
        this.jpaStudentRepository.delete(studentEntity);

    }


}
