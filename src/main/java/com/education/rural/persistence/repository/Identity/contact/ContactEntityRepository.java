package com.education.rural.persistence.repository.Identity.contact;


import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;
import com.education.rural.domain.repository.Identity.ContactRepository;
import com.education.rural.persistence.entity.Identity.ContactEntity;
import com.education.rural.persistence.mapper.Identity.ContactMapper;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactEntityRepository implements ContactRepository {

    private final JpaContactRepository jpaContactRepository;
    private final ContactMapper contactMapper;

    public ContactEntityRepository(JpaContactRepository jpaContactRepository, ContactMapper contactMapper) {
        this.jpaContactRepository = jpaContactRepository;
        this.contactMapper = contactMapper;
    }


    @Override
    public List<ContactDto> findAll() {
        return this.contactMapper.toContactsDto(this.jpaContactRepository.findAll());
    }

    @Override
    public ContactDto findById(Integer id) {
        return this.contactMapper.toContactDto(this.jpaContactRepository.findById(id).orElseThrow(()->new RuntimeException("Contact not found!")));
    }

    @Override
    public ContactDto findByContactEmail(String email) {
        return this.contactMapper.toContactDto(this.jpaContactRepository.findFirstByContactEmailIgnoreCase(email));
    }



    @Override
    public ContactDto saveContact(ContactDto contactDto) {
        ContactEntity contactEntity = this.contactMapper.toContactEntity(contactDto);
        ContactEntity savedContact=this.jpaContactRepository.save(contactEntity);
        return contactMapper.toContactDto(savedContact);
    }

    @Override
    public ContactDto updateContact(Integer id, ContactDto contactDto) {
        ContactEntity contactEntity = this.jpaContactRepository.findById(id).orElseThrow(()->new RuntimeException("Contact not found!"));
        ContactEntity savedContact=this.jpaContactRepository.save(contactEntity);
        return this.contactMapper.toContactDto(savedContact);
    }


    @Override
    public ContactDto patchContact(Integer id, UpdateContactDto updateContactDto) {
        ContactEntity contactEntity = this.jpaContactRepository.findById(id).orElseThrow(()->new RuntimeException("contact not found"));
        this.contactMapper.UpdateContactFromDto(updateContactDto,contactEntity);
        return this.contactMapper.toContactDto(this.jpaContactRepository.save(contactEntity));
    }

    @Override
    public void deleteContactById(Integer id) {
        ContactEntity contactEntity=this.jpaContactRepository.findById(id).orElseThrow(()->new RuntimeException("contact not found"));
        this.jpaContactRepository.delete(contactEntity);
        System.out.println("delete By contactId contact successfully");

    }

    @Override
    public void deleteContactByEmail(String email) {
        if(this.jpaContactRepository.findFirstByContactEmailIgnoreCase(email)!=null){

            this.jpaContactRepository.deleteByContactEmailIgnoreCase(email);
            System.out.println("Contact with email "+email+" successfully deleted");
        };
    }
}
