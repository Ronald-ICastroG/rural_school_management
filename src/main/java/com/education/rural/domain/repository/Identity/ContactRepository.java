package com.education.rural.domain.repository.Identity;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;

import java.util.List;

public interface ContactRepository {

    List<ContactDto> findAll();
    ContactDto findById(Integer id);
    ContactDto findByContactEmail(String email);
    ContactDto saveContact(ContactDto contactDto);
    ContactDto updateContact(Integer id,ContactDto contactDto);
    ContactDto patchContact(Integer id, UpdateContactDto updateContactDto);
    void deleteContactById(Integer id);

    void deleteContactByEmail(String email);
}
