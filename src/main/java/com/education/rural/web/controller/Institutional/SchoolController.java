package com.education.rural.web.controller.Institutional;

import com.education.rural.domain.dto.institutional.school.SchoolDto;
import com.education.rural.domain.dto.institutional.school.UpdateSchoolDto;
import com.education.rural.domain.service.Institutional.school.ISchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@Tag(name="Schools", description = "Core clase of institutional layer, methods to manage and operate school")
public class SchoolController {

    private final ISchoolService schoolService;

    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    @Operation(summary = "Get ALl schools",
            description = "Return all schools from database",
            responses = @ApiResponse(responseCode = "200",description = "found all schools")
    )
    public ResponseEntity<List<SchoolDto>> findAllSchool() {
        return ResponseEntity.ok(this.schoolService.findAllSchool());
    }


    @GetMapping("/{id:[0-9]+}")
    @Operation(summary = "Get school using schoolId",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found school using id")
    )
    public ResponseEntity<SchoolDto> findSchoolById(@PathVariable long id) {
        SchoolDto schoolDto = this.schoolService.getSchoolById(id);
        return (schoolDto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(schoolDto));
    }

    @PostMapping
    @Operation(summary = "save school giving json parameters",
            responses =
            @ApiResponse(responseCode = "201",description = ", school created")
    )
    public ResponseEntity<SchoolDto> save(@RequestBody @Valid SchoolDto schoolDto) {
        System.out.println(schoolDto.toString());
        return new ResponseEntity<>(this.schoolService.addSchool(schoolDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(summary = " Partial school update giving json parameters and pathVariable Id",
            responses =
            @ApiResponse(responseCode = "202",description = ", patch school accepted")
    )
    public ResponseEntity<SchoolDto> update(@PathVariable long id, @RequestBody @Valid UpdateSchoolDto updateSchoolDto) {
        return new ResponseEntity<>(this.schoolService.updateSchool(id, updateSchoolDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = " delete school giving pathVariable school Id",
            responses =
            @ApiResponse(responseCode = "204",description = "No content, school deleted")
    )
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.schoolService.deleteSchool(id);
        System.out.println("School with id: " + id + " deleted");
        return ResponseEntity.noContent().build();
    }


}


