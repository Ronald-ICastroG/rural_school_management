package com.education.rural.web.controller.Institutional;

import com.education.rural.domain.dto.institutional.campus.CampusDto;
import com.education.rural.domain.dto.institutional.campus.UpdateCampusDto;
import com.education.rural.domain.service.Institutional.campus.ICampusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campus")
@Tag(name="Campus",description = "Operations about campus")
public class CampusController {
    private final ICampusService campusService;

    public CampusController(ICampusService campusService) {
        this.campusService = campusService;
    }


    @GetMapping
    @Operation(summary = "Get ALl campus",
    description = "Return all campus from database",
            responses = @ApiResponse(responseCode = "200",description = "found all movies")
    )
    public ResponseEntity<List<CampusDto>> getAllCampus(){
        return ResponseEntity.ok(this.campusService.findAllCampus());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get campus using campusId",
    responses =
    @ApiResponse(responseCode = "200",description = "Ok, found campus using id")
    )
    public ResponseEntity<CampusDto> getCampusById(@PathVariable Integer id){
        return ResponseEntity.ok(this.campusService.findCampusById(id));
    }

    @Operation(summary = "Get campus using campusName",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok")
    )
    @GetMapping("/named/{name}")
    public ResponseEntity<CampusDto> getCampusByName(@PathVariable String name){
        return ResponseEntity.ok(this.campusService.findCampusByName(name));
    }

    @Operation(summary = "save campus giving json parameters",
            responses =
            @ApiResponse(responseCode = "201",description = ", created")
    )
    @PostMapping
    public ResponseEntity<CampusDto> saveCampus(@RequestBody CampusDto campusDto){
        return new  ResponseEntity<>(this.campusService.saveCampus(campusDto),HttpStatus.CREATED);
    }


    @PatchMapping("/{id}")
    @Operation(summary = " Partial Update campus giving json parameters and pathVariable Id",
            responses =
            @ApiResponse(responseCode = "202",description = ", patch accepted")
    )
    public ResponseEntity<CampusDto> patchCampus(@PathVariable Integer id,@RequestBody UpdateCampusDto updateCampusDto){
        return new ResponseEntity<>(this.campusService.patchCampus(id,updateCampusDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = " delete campus giving pathVariable campus Id",
            responses =
            @ApiResponse(responseCode = "204",description = "No content")
    )
    public ResponseEntity<CampusDto> deleteCampus(@PathVariable Integer id){
        this.campusService.deleteCampus(id);
        return ResponseEntity.noContent().build();
    }
}
