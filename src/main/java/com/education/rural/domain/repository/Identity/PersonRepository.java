package com.education.rural.domain.repository.Identity;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;

import java.util.List;

public interface PersonRepository {

    List<PersonDto> getAllPersons();
    PersonDto getPersonById(Integer id);
    PersonDto getPersonByName(String name);
    PersonDto getPersonByDni(String personDni);
    PersonDto savePerson(PersonDto personDto);
    PersonDto patchPerson(Integer id, UpdatePersonDto updatePersonDto);
    void deletePersonById(Integer id);
    void deletePersonByPersonDni(String personDni);
}
