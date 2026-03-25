package com.education.rural.domain.service.Identity.contact;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;

import java.util.List;

public interface IContactService {

    List<ContactDto> getAll();
    ContactDto getById(Integer id);
    ContactDto getByEmail(String email);
    ContactDto save(ContactDto contactDto);
    ContactDto update(Integer id,ContactDto contactDto);
    ContactDto patch(Integer id, UpdateContactDto updateContactDto);
    void deleteByContactId(Integer id);

    void deleteByContactEmail(String email);
}
