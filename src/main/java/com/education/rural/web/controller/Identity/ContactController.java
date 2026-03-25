package com.education.rural.web.controller.Identity;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;
import com.education.rural.domain.service.Identity.contact.IContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/contact")
@Tag(name = "Contacts",description = "Contacts associateds to a person")
public class ContactController {


    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    @Operation(summary = "Get ALl Contacts",
            description = "Return all contacts from database",
            responses = @ApiResponse(responseCode = "200",description = "found all contacts")
    )
    public ResponseEntity<List<ContactDto>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }

    @GetMapping("/mail/{email}")
    @Operation(summary = "Get contact using contact email",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found person using contact email, method created as JpaContactRepository findFirstByContactEmailIgnoreCase")
    )
    public ResponseEntity<ContactDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(this.contactService.getByEmail(email));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get contact using contact id",
            responses =
            @ApiResponse(responseCode = "200",description = "Ok, found person using contact id")
    )
    public ResponseEntity<ContactDto> getById(@PathVariable Integer id) {
        return  ResponseEntity.ok(this.contactService.getById(id));
    }

    @PostMapping
    @Operation(summary = "save contact giving json parameters",
            responses =
            @ApiResponse(responseCode = "201",description = ", contact created")
    )
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contactDto) {
        return ResponseEntity.ok(this.contactService.save(contactDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = " contact update giving json parameters and pathVariable Id",
            responses =
            @ApiResponse(responseCode = "202",description = ",contact update accepted")
    )
    public ResponseEntity<ContactDto>updateContact(@PathVariable Integer id, @RequestBody ContactDto contactDto) {
        return new ResponseEntity<>(this.contactService.update(id, contactDto), HttpStatus.ACCEPTED);
    }


    @PatchMapping("/{id}")
    @Operation(summary = " Partial contact update giving json parameters and pathVariable Id",
            responses =
            @ApiResponse(responseCode = "202",description = ", patch contact accepted")
    )
    public ResponseEntity<ContactDto> update(@PathVariable Integer id, @RequestBody UpdateContactDto updateContactDto) {
        return new ResponseEntity<>(this.contactService.patch(id,updateContactDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = " delete contact giving pathVariable contac Id and json parameters",
            responses =
            @ApiResponse(responseCode = "204",description = "No content, contact deleted")
    )
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.contactService.deleteByContactId(id);
        return  ResponseEntity.noContent().build();
    }
    @DeleteMapping("/mail/{email}")
    @Operation(summary = " delete contact giving pathVariable contact email and json parameters",
            responses =
            @ApiResponse(responseCode = "204",description = "No content, contact deleted, JPQL method created as JpaContactRepository DeleteByContactEmailIgnoreCase")
    )
    public ResponseEntity<Void> deleteContactByEmail(@PathVariable String email) {
        this.contactService.deleteByContactEmail(email);
        return  ResponseEntity.noContent().build();
    }

}
