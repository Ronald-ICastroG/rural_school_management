package com.education.rural.web.controller.Academic;

import com.education.rural.domain.dto.Academic.academicAssignment.AcademicAssignmentDto;
import com.education.rural.domain.dto.Academic.academicAssignment.UpdateAcademicAssignmentDto;
import com.education.rural.domain.service.Academic.AcademicAssignment.IAcademicAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic/assignment")
@Tag(name = "Academic_assignment",description = "CrudMethods to select, create, update and delete academic assignment")
public class AcademicAssignmentController {

    private final IAcademicAssignmentService academicAssignmentService;

    public AcademicAssignmentController(IAcademicAssignmentService academicAssignmentService) {
        this.academicAssignmentService = academicAssignmentService;
    }

    @GetMapping
    @Operation(
            summary = "Get ALl assignments from table",
            description = "Return all Assignment for each period",
            responses = {@ApiResponse(responseCode = "200",description = "Ok, ALl elements recovered")}
    )
    public ResponseEntity<List<AcademicAssignmentDto>> getAcademicAssignments() {
        return ResponseEntity.ok(this.academicAssignmentService.findAll());
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Get assignments by id",
            description = "Return Assignment giving id ",
            responses = {@ApiResponse(responseCode = "200",description = "Ok, element recovered")}
    )
    public ResponseEntity<AcademicAssignmentDto> getAcademicAssignmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.academicAssignmentService.findById(id));
    }

    @PostMapping
    @Operation(
            summary = "save academicAssignment giving json paramethers",
            description = "create a new academic assignment giving json paramethers",
            responses = {@ApiResponse(responseCode = "201",description = "Created, new assignment created")}
    )
    public ResponseEntity<AcademicAssignmentDto>save(@RequestBody AcademicAssignmentDto academicAssignmentDto) {
        return new ResponseEntity<>(this.academicAssignmentService.save(academicAssignmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "save academicAssignment giving json paramethers",
            description = "create a new academic assignment giving  id on path and json paramethers",
            responses = {@ApiResponse(responseCode = "202",description = "Accepted, assignment updated")}
    )
    public ResponseEntity<AcademicAssignmentDto>update(@PathVariable Integer id,@RequestBody UpdateAcademicAssignmentDto updateAcademicAssignmentDto) {
        return new ResponseEntity<>(this.academicAssignmentService.update(id,updateAcademicAssignmentDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete assignment by id",
            description = "Delete Assignment giving id ",
            responses = {@ApiResponse(responseCode = "204",description = "No content, assignment deleted")}
    )
    public ResponseEntity<Void>delete(@PathVariable Integer id) {
        this.academicAssignmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
