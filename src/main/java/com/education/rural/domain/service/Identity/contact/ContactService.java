package com.education.rural.domain.service.Identity.contact;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;
import com.education.rural.domain.repository.Identity.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactDto> getAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public ContactDto getById(Integer id) {
        return this.contactRepository.findById(id);
    }

    @Override
    public ContactDto getByEmail(String email) {
        return this.contactRepository.findByContactEmail(email);
    }

    @Override
    public ContactDto save(ContactDto contactDto) {
        return this.contactRepository.saveContact(contactDto);
    }

    @Override
    public ContactDto update(Integer id,ContactDto contactDto) {
        return this.contactRepository.updateContact(id,contactDto);
    }

    @Override
    public ContactDto patch(Integer id, UpdateContactDto updateContactDto) {
        return this.contactRepository.patchContact(id, updateContactDto);
    }

    @Override
    public void deleteByContactId(Integer id) {
        this.contactRepository.deleteContactById(id);
        System.out.println("Contact " + id + " deleted");
    }

    @Override
    public void deleteByContactEmail(String email) {
        this.contactRepository.deleteContactByEmail(email);
    }
}
