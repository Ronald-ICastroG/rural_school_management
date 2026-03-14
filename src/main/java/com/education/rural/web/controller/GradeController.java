package com.education.rural.web.controller;

import com.education.rural.domain.dto.grade.GradeDto;
import com.education.rural.domain.dto.grade.UpdateGradeDto;
import com.education.rural.domain.service.grade.IGradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final IGradeService gradeService;


    public GradeController(IGradeService gradeService) {
        this.gradeService = gradeService;
    }


    @GetMapping
    public ResponseEntity<List<GradeDto>> findAll() {
        return ResponseEntity.ok(this.gradeService.findAllCampus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.gradeService.findById(id));
    }

    @GetMapping("/named/{name}")
    public ResponseEntity<GradeDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(this.gradeService.findByGradeNameIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<GradeDto> save(@RequestBody GradeDto gradeDto) {
        return  new ResponseEntity<>(this.gradeService.saveGrade(gradeDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GradeDto> patch(@PathVariable Integer id,@RequestBody UpdateGradeDto updateGradeDto) {
        return new  ResponseEntity<>(this.gradeService.patchGrade(id,updateGradeDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }


}
