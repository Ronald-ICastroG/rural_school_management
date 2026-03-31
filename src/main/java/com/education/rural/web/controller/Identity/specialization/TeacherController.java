package com.education.rural.web.controller.Identity.specialization;


import com.education.rural.domain.dto.Identity.specialization.teacher.TeacherDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.UpdateTeacherDto;
import com.education.rural.domain.service.Identity.specialization.teacher.ITeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Tag(name="Teachers",description = "Crud methods for teacher management")
public class TeacherController {


    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping
    @Operation(summary = "Get All teachers ",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found ALl Teachers")
    )
    public ResponseEntity<List<TeacherDto>> findAllTeachers() {
        return ResponseEntity.ok(this.teacherService.findTeachers());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get teacher By Id",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found teacher by id")
    )
    public ResponseEntity<TeacherDto> findTeacherById(@PathVariable int id) {
        return ResponseEntity.ok(this.teacherService.getTeacherById(id));
    }

    @PostMapping
    @Operation(summary = "save teacher giving json paramethers",
            responses =
            @ApiResponse(responseCode = "201",description = "create teacher")
    )
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
      return new ResponseEntity<>(this.teacherService.saveTeacher(teacherDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update teacher giving id and jsonParamethers",
            responses =
            @ApiResponse(responseCode = "202",description = "accepted,teacher updated")
    )
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Integer id, @RequestBody UpdateTeacherDto updateTeacherDto) {
        return new ResponseEntity<>(this.teacherService.patchTeacher(id,updateTeacherDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete teacher By id",
            responses =
            @ApiResponse(responseCode = "204",description = "No Content")
    )
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        this.teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

}
