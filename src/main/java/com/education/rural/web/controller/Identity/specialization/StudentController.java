package com.education.rural.web.controller.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.student.StudentDto;
import com.education.rural.domain.dto.Identity.specialization.student.UpdateStudentDto;
import com.education.rural.domain.service.Identity.specialization.student.IStudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/students")
@Tag(name="Students",description = "Students, specialization")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }


    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(this.studentService.save(studentDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer id, @RequestBody UpdateStudentDto updateStudentDto) {
        return new ResponseEntity<>(this.studentService.patchStudent(id,updateStudentDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        this.studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
