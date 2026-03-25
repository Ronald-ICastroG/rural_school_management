package com.education.rural.web.controller.Institutional;

import com.education.rural.domain.dto.institutional.grade.GradeDto;
import com.education.rural.domain.dto.institutional.grade.UpdateGradeDto;
import com.education.rural.domain.service.Institutional.grade.IGradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
@Tag(name="Grades",description = "Operations about grade entity ")
public class GradeController {

    private final IGradeService gradeService;


    public GradeController(IGradeService gradeService) {
        this.gradeService = gradeService;
    }



    @GetMapping
    @Operation(
            summary = "Get all grades",
            description = "Return all grades from database",
            responses={
                    @ApiResponse(responseCode = "200",description = "Found all grades")

    }
    )
    public ResponseEntity<List<GradeDto>> findAll() {
        return ResponseEntity.ok(this.gradeService.findAllCampus());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get grades using gradeId",
            description = "Return grade using gradeId",
            responses={
                    @ApiResponse(responseCode = "200",description = "Found grade by Id")

            }
    )
    public ResponseEntity<GradeDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.gradeService.findById(id));
    }




    @Operation(
            summary = "Get grades using gradeName",
            description = "Return grade using gradeName",
            responses={
                    @ApiResponse(responseCode = "200",description = "Found grade by name")

            }
    )
    @GetMapping("/named/{name}")
    public ResponseEntity<GradeDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(this.gradeService.findByGradeNameIgnoreCase(name));
    }

    @PostMapping
    @Operation(
            summary = "save grade, giving json",
            description = "return acepted",
            responses={
                    @ApiResponse(responseCode = "201",description = "Grade created")

            }
    )
    public ResponseEntity<GradeDto> save(@RequestBody GradeDto gradeDto) {
        return  new ResponseEntity<>(this.gradeService.saveGrade(gradeDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Patch or partial update grade using id",
            description = "Return http status code 201, accepted",
            responses={
                    @ApiResponse(responseCode = "201",description = " grade patched accepted")

            }
    )
    @PatchMapping("/{id}")
    public ResponseEntity<GradeDto> patch(@PathVariable Integer id,@RequestBody UpdateGradeDto updateGradeDto) {
        return new  ResponseEntity<>(this.gradeService.patchGrade(id,updateGradeDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete grade using id",
            description = "Return http status code 204, No content",
            responses={
                    @ApiResponse(responseCode = "204",description = " No Content")

            }
    )
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }


}
