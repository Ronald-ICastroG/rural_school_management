package com.education.rural.domain.service.Identity.person;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;

import java.util.List;

public interface IPersonService {

    List<PersonDto> getAll();
    PersonDto getById(Integer id);
    PersonDto getByName(String name);
    PersonDto getByDni(String dni);
    PersonDto save(PersonDto personDto);
    PersonDto patch(Integer id, UpdatePersonDto updatePersonDto);
    void delete(Integer id);
    void deleteByPersonDni(String personDni);
}
