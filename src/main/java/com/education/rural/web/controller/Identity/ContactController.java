package com.education.rural.web.controller.Identity;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;
import com.education.rural.domain.service.Identity.contact.IContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/contact")
public class ContactController {


    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }

    @GetMapping("/mail/{email}")
    public ResponseEntity<ContactDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(this.contactService.getByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> getById(@PathVariable Integer id) {
        return  ResponseEntity.ok(this.contactService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contactDto) {
        return ResponseEntity.ok(this.contactService.save(contactDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto>updateContact(@PathVariable Integer id, @RequestBody ContactDto contactDto) {
        return new ResponseEntity<>(this.contactService.update(id, contactDto), HttpStatus.ACCEPTED);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ContactDto> update(@PathVariable Integer id, @RequestBody UpdateContactDto updateContactDto) {
        return new ResponseEntity<>(this.contactService.patch(id,updateContactDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.contactService.deleteByContactId(id);
        return  ResponseEntity.noContent().build();
    }
    @DeleteMapping("/mail/{email}")
    public ResponseEntity<Void> deleteContactByEmail(@PathVariable String email) {
        this.contactService.deleteByContactEmail(email);
        return  ResponseEntity.noContent().build();
    }

}
