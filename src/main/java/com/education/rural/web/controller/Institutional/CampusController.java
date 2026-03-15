package com.education.rural.web.controller.Institutional;

import com.education.rural.domain.dto.institutional.campus.CampusDto;
import com.education.rural.domain.dto.institutional.campus.UpdateCampusDto;
import com.education.rural.domain.service.Institutional.campus.ICampusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campus")
public class CampusController {
    private final ICampusService campusService;

    public CampusController(ICampusService campusService) {
        this.campusService = campusService;
    }


    @GetMapping
    public ResponseEntity<List<CampusDto>> getAllCampus(){
        return ResponseEntity.ok(this.campusService.findAllCampus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampusDto> getCampusById(@PathVariable Integer id){
        return ResponseEntity.ok(this.campusService.findCampusById(id));
    }

    @GetMapping("/named/{name}")
    public ResponseEntity<CampusDto> getCampusByName(@PathVariable String name){
        return ResponseEntity.ok(this.campusService.findCampusByName(name));
    }

    @PostMapping
    public ResponseEntity<CampusDto> saveCampus(@RequestBody CampusDto campusDto){
        return new  ResponseEntity<>(this.campusService.saveCampus(campusDto),HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CampusDto> patchCampus(@PathVariable Integer id,@RequestBody UpdateCampusDto updateCampusDto){
        return new ResponseEntity<>(this.campusService.patchCampus(id,updateCampusDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CampusDto> deleteCampus(@PathVariable Integer id){
        this.campusService.deleteCampus(id);
        return ResponseEntity.noContent().build();
    }
}
