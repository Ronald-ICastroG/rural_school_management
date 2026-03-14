package com.education.rural.web.controller;

import com.education.rural.domain.dto.school.SchoolDto;
import com.education.rural.domain.dto.school.UpdateSchoolDto;
import com.education.rural.domain.service.school.ISchoolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    private final ISchoolService schoolService;

    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<List<SchoolDto>> findAllSchool() {
        return ResponseEntity.ok(this.schoolService.findAllSchool());
    }


    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<SchoolDto> findSchoolById(@PathVariable long id) {
        SchoolDto schoolDto = this.schoolService.getSchoolById(id);
        return (schoolDto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(schoolDto));
    }

    @PostMapping
    public ResponseEntity<SchoolDto> save(@RequestBody @Valid SchoolDto schoolDto) {
        System.out.println(schoolDto.toString());
        return new ResponseEntity<>(this.schoolService.addSchool(schoolDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SchoolDto> update(@PathVariable long id, @RequestBody @Valid UpdateSchoolDto updateSchoolDto) {
        return new ResponseEntity<>(this.schoolService.updateSchool(id, updateSchoolDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.schoolService.deleteSchool(id);
        System.out.println("School with id: " + id + " deleted");
        return ResponseEntity.noContent().build();
    }


}


