package com.education.rural.web.controller.Identity;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;
import com.education.rural.domain.service.Identity.person.IPersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name="Persons",description = "Operations about person entity")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    @Operation(summary = "Get ALl persons",
            description = "Return all persons from database",
            responses = @ApiResponse(responseCode = "200",description = "found all persons")
    )
    public ResponseEntity<List<PersonDto>> getAll(){
        return ResponseEntity.ok(this.personService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get person using campusId",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found person using id")
    )
    public ResponseEntity<PersonDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(this.personService.getById(id));
    }

    @GetMapping("/named/{name}")
    @Operation(summary = "Get person using personFirstName",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found person using firstName")
    )
    public ResponseEntity<PersonDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.personService.getByName(name));
    }
    @GetMapping("/dni/{dni}")
    @Operation(summary = "Get person using personDni",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found person using dni")
    )
    public ResponseEntity<PersonDto> getByDni(@PathVariable String dni){
        return ResponseEntity.ok(this.personService.getByDni(dni));
    }

    @PostMapping
    @Operation(summary = "save person giving json parameters",
            responses =
            @ApiResponse(responseCode = "201",description = ", person created")
    )
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(this.personService.save(personDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(summary = " Partial person update giving json parameters and pathVariable Id",
            responses =
            @ApiResponse(responseCode = "202",description = ", patch person accepted")
    )
    public ResponseEntity<PersonDto> patchPerson(@PathVariable Integer id,@RequestBody UpdatePersonDto updatePersonDto){
        return new ResponseEntity<>(this.personService.patch(id,updatePersonDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = " delete person giving pathVariable person Id",
            responses =
            @ApiResponse(responseCode = "204",description = "No content, person deleted")
    )
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id){
        this.personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/dni/{personDni}")
    @Operation(summary = " delete person giving pathVariable personDni",
            responses =
            @ApiResponse(responseCode = "204",description = "No content, person deleted,JPQL method created as jpaPersonRepository named deleteByPersonDniIgnoreCase")
    )
    public ResponseEntity<Void> deleteByPersonDni(@PathVariable String personDni) {
        this.personService.deleteByPersonDni(personDni);
        return ResponseEntity.noContent().build();
    }
}
