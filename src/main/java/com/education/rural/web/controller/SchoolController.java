package com.education.rural.web.controller;

import com.education.rural.domain.dto.SchoolDto;
import com.education.rural.domain.service.ISchoolService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
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


    @GetMapping("/{id}")
    public ResponseEntity<SchoolDto> findSchoolById(@PathVariable long id) {
        SchoolDto schoolDto=this.schoolService.getSchoolById(id);
        return (schoolDto==null?ResponseEntity.notFound().build():ResponseEntity.ok(schoolDto));
    }

    @PostMapping
    public ResponseEntity<SchoolDto> save(@RequestBody SchoolDto schoolDto) {
        System.out.println(schoolDto.toString());
        return new ResponseEntity<>(this.schoolService.addSchool(schoolDto), HttpStatus.CREATED);
    }
}
