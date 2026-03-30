package com.education.rural.domain.service.Identity.specialization.student;

import com.education.rural.domain.dto.Identity.specialization.student.StudentDto;
import com.education.rural.domain.dto.Identity.specialization.student.UpdateStudentDto;
import com.education.rural.domain.repository.Identity.specialization.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return this.studentRepository.findAllStudents();
    }

    @Override
    public StudentDto findStudentById(Integer id) {
        return this.studentRepository.findStudentById(id);
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        return this.studentRepository.saveStudent(studentDto);
    }

    @Override
    public StudentDto patchStudent(Integer id, UpdateStudentDto updateStudentDto) {
        return this.studentRepository.patchStudent(id, updateStudentDto);
    }

    @Override
    public void deleteStudent(Integer id) {
        this.studentRepository.deleteStudentById(id);
        System.out.println("Student with id " + id + " has been deleted");
    }
}
