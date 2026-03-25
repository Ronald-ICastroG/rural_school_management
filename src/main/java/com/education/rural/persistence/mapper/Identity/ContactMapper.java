package com.education.rural.persistence.mapper.Identity;

import com.education.rural.domain.dto.Identity.contact.ContactDto;
import com.education.rural.domain.dto.Identity.contact.UpdateContactDto;
import com.education.rural.persistence.entity.Identity.ContactEntity;
import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    List<ContactDto> toContactsDto(Iterable<ContactEntity> contacts);

    @Mapping(target="person.personId",source="personId")
    ContactEntity toContactEntity(ContactDto contactDto);

    @InheritInverseConfiguration
    @Mapping(target="personId",source = "person.personId")
    ContactDto toContactDto(ContactEntity contactEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="contactId",ignore = true)
    @Mapping(target="person",ignore=true)
    void UpdateContactFromDto(UpdateContactDto updateContactDto,@MappingTarget ContactEntity contactEntity);
}
