package com.education.rural.web.controller.Academic;

import com.education.rural.domain.dto.Academic.subject.SubjectDto;
import com.education.rural.domain.dto.Academic.subject.UpdateSubjectDto;
import com.education.rural.domain.service.Academic.Subject.ISubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academic/subject")
@Tag(name="subjects",description = "operations about subjects ")
public class SubjectController {

    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    @Operation(
            summary = "Select all Subjects ",
            description = "Select All subjects ",
            responses = {@ApiResponse(responseCode = "200",description = "Ok")}
    )
    public ResponseEntity<List<?>> findAllSubjects(){
        return ResponseEntity.ok(subjectService.findAllSubjects());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Select subject giving subjectId on path ",
            description = "Delete subject giving  id on path ",
            responses = {@ApiResponse(responseCode = "200",description = "Ok")}
    )
    public ResponseEntity<?> findSubjectById(@PathVariable Integer id){
        return ResponseEntity.ok(subjectService.findSubjectById(id));
    }

    @GetMapping("/named/{subjectName}")
    @Operation(
            summary = "Select subject giving subjectName on path ",
            description = "Delete subject giving  id on path ",
            responses = {@ApiResponse(responseCode = "200",description = "Ok")}
    )
    public ResponseEntity<SubjectDto> findSubjectByName(@PathVariable String subjectName){
        return ResponseEntity.ok(this.subjectService.findFirstBySubjectNameIgnoreCase(subjectName));
    }

    @PostMapping
    @Operation(
            summary = "save subject giving json paramethers",
            description = "create a new subject giving json paramethers",
            responses = {@ApiResponse(responseCode = "201",description = "Created, subject updated")}
    )
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto){
        return new  ResponseEntity<>(this.subjectService.saveSubject(subjectDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Partial or complete subject udpate  giving id on path and json paramethers",
            description = "create a new subject giving  id on path and json paramethers",
            responses = {@ApiResponse(responseCode = "202",description = "Accepted, subject updated")}
    )
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable Integer id, @RequestBody UpdateSubjectDto updateSubjectDto){
        return new ResponseEntity<>(this.subjectService.patchSubject(id,updateSubjectDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/named/{name}")
    @Operation(
            summary = "Delete subject giving subjectName on path ",
            description = "Delete subject giving  id on path ",
            responses = {@ApiResponse(responseCode = "204",description = "No Content, subject deleted by name")}
    )
    public ResponseEntity<Void>  deleteSubjectByName(@PathVariable String name){
            this.subjectService.deleteBySubjectNameIgnoreCase(name);
            return ResponseEntity.noContent().build();
        }



    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete subject giving id on path ",
            description = "Delete subject giving  id on path ",
            responses = {@ApiResponse(responseCode = "204",description = "No Content, subject deleted By Id")}
    )
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        this.subjectService.deleteSubjectById(id);
        return ResponseEntity.noContent().build();
    }
}
