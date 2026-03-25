package com.education.rural.web.controller.Identity;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;
import com.education.rural.domain.service.Identity.person.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return ResponseEntity.ok(this.personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(this.personService.getById(id));
    }

    @GetMapping("/named/{name}")
    public ResponseEntity<PersonDto> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.personService.getByName(name));
    }
    @GetMapping("/dni/{dni}")
    public ResponseEntity<PersonDto> getByDni(@PathVariable String dni){
        return ResponseEntity.ok(this.personService.getByDni(dni));
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(this.personService.save(personDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonDto> patchPerson(@PathVariable Integer id,@RequestBody UpdatePersonDto updatePersonDto){
        return new ResponseEntity<>(this.personService.patch(id,updatePersonDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id){
        this.personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/dni/{personDni}")
    public ResponseEntity<Void> deleteByPersonDni(@PathVariable String personDni) {
        this.personService.deleteByPersonDni(personDni);
        return ResponseEntity.noContent().build();
    }
}
