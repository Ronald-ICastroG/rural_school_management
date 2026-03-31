package com.education.rural.web.controller.Identity.specialization;


import com.education.rural.domain.dto.Identity.specialization.staff.StaffDto;
import com.education.rural.domain.dto.Identity.specialization.staff.UpdateStaffDto;
import com.education.rural.domain.service.Identity.specialization.staff.IStaffService;
import com.education.rural.domain.service.Identity.specialization.staff.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@Tag(name="staff memebers")
public class StaffController {

private final IStaffService staffService;


    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    @Operation(summary = "Get All StaffMembers",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, All StaffMembers recovered")
    )
    public ResponseEntity<List<StaffDto>> findAll() {
        return ResponseEntity.ok(this.staffService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get StaffMember By Id",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found StaffMember by id")
    )
    public ResponseEntity<StaffDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.staffService.findById(id));
    }
    @PostMapping
    @Operation(summary = "Save Staff Memeber giving json params",
            responses =
            @ApiResponse(responseCode = "201",description = "Created, Staff MembeCreated")
    )
    public ResponseEntity<StaffDto> saveStaff(@RequestBody StaffDto staffDto) {
        return new ResponseEntity<>(this.staffService.save(staffDto), HttpStatus.CREATED);
    }
    @PatchMapping("/{id}")
    @Operation(summary = "Partial staff Update ",
            responses =
            @ApiResponse(responseCode = "202",description = "ACcepted, changes applied by id")
    )
    public ResponseEntity<StaffDto> patchStaff(@PathVariable Integer id, @RequestBody UpdateStaffDto updateStaffDto) {
        return new ResponseEntity<>(this.staffService.patch(id,updateStaffDto),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Staff By Id",
            responses =
            @ApiResponse(responseCode = "204",description = "no cONTENT")
    )
    public ResponseEntity<Void> deleteStaff(@PathVariable Integer id) {
        this.staffService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
