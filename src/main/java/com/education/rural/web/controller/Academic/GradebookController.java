package com.education.rural.web.controller.Academic;

import com.education.rural.domain.dto.Academic.Gradebook.GradebookDto;
import com.education.rural.domain.dto.Academic.Gradebook.UpdateGradebookDto;
import com.education.rural.domain.service.Academic.Gradebook.IGradebookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic/gradebook")
@Tag(name="Gradebook",description = "Operations about Gradebook")
public class GradebookController {

    private final IGradebookService gradebookService;


    public GradebookController(IGradebookService gradebookService) {
        this.gradebookService = gradebookService;
    }


    @GetMapping
    @Operation(summary = "Get All gradebooks",
            description = "Get all gradebooks",
            responses={@ApiResponse(responseCode = "200",description = "ok")
    })
    public ResponseEntity<List<GradebookDto>> getGradebook() {
        return ResponseEntity.ok(this.gradebookService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get gradebook giving id",
            description = "Get gradebook giving id on path",
            responses={@ApiResponse(responseCode = "200",description = "ok")
            })
    public ResponseEntity<GradebookDto> getGradebookById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.gradebookService.findById(id));
    }

    @PostMapping
    @Operation(summary = "save gradebook",
            description = "save gradebook giving json paramethers",
            responses={@ApiResponse(responseCode = "201",description = "created")
            })
    public ResponseEntity<GradebookDto> saveGradebook(@RequestBody GradebookDto gradebookDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.gradebookService.save(gradebookDto));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "partial update gradebook",
            description = "partial update gradebook giving id on path and json paramethers",
            responses={@ApiResponse(responseCode = "202",description = "Accepted")
            })
    public ResponseEntity<GradebookDto> patchGradebook(@PathVariable Integer id,@RequestBody UpdateGradebookDto updateGradebookDto) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.gradebookService.patch(id, updateGradebookDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete gradebook giving id",
            description = "delete gradebook giving id on path",
            responses={@ApiResponse(responseCode = "204",description = "No content")
            })
    public ResponseEntity<Void> deleteGradebook(@PathVariable Integer id) {
        this.gradebookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
