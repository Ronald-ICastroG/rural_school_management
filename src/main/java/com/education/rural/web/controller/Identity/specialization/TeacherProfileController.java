package com.education.rural.web.controller.Identity.specialization;

import com.education.rural.domain.dto.Identity.specialization.teacher.profile.TeacherProfileDto;
import com.education.rural.domain.dto.Identity.specialization.teacher.profile.UpdateTeacherProfileDto;
import com.education.rural.domain.service.Identity.specialization.teacher.profile.ITeacherProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/profile")
@Tag(name="Teachers_profile")
public class TeacherProfileController {


private final ITeacherProfileService teacherProfileService;


    public TeacherProfileController(ITeacherProfileService teacherProfileService) {
        this.teacherProfileService = teacherProfileService;
    }

    @GetMapping
    @Operation(summary = "Get All teachers profiles",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found ALl TeachersProfiles")
    )
    public ResponseEntity<List<TeacherProfileDto>>findAllTeacherProfile() {
        return ResponseEntity.ok(this.teacherProfileService.findAllTeacherProfile());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get teacher profile using id",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found Teacher profile using id")
    )
    public ResponseEntity<TeacherProfileDto> findTeacherProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.teacherProfileService.findTeacherProfileById(id));
    }

    @GetMapping("/name/{profileName}")
    @Operation(summary = "Get teacher profile using profile name",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found Teacher profile using profile name")
    )
    public  ResponseEntity<TeacherProfileDto> saveTeacherProfile(@PathVariable String profileName) {
        return ResponseEntity.ok(this.teacherProfileService.findFirstByProfileNameIgnoreCase(profileName));
    }

    @PostMapping
    @Operation(summary = "save TeacherProfile giving json parameters",
            responses =
            @ApiResponse(responseCode = "201",description = "created teacher profile")
    )
    public ResponseEntity<TeacherProfileDto> saveTeacherProfile(@RequestBody TeacherProfileDto dto) {
        return new ResponseEntity<>(this.teacherProfileService.saveProfile(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "partial Update  TeacherProfile giving json parameters, and id",
            responses =
            @ApiResponse(responseCode = "202",description = "Change Accepted for teachers profile")
    )
    public  ResponseEntity<TeacherProfileDto> updateTeacherProfile(@PathVariable Integer id, @RequestBody UpdateTeacherProfileDto dto) {
        return new ResponseEntity<>(this.teacherProfileService.patchTeacherProfile(id,dto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "deleteById TeacherProfile giving id on path",
            responses =
            @ApiResponse(responseCode = "204",description = "No content")
    )
    public ResponseEntity<Void> deleteTeacherProfile(@PathVariable Integer id) {
        this.teacherProfileService.deleteTeacherProfileById(id);
        return ResponseEntity.noContent().build();
    }
}
