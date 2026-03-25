package com.education.rural.domain.service.Identity.person;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;
import com.education.rural.domain.repository.Identity.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

     private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<PersonDto> getAll() {
        return this.personRepository.getAllPersons();
    }

    @Override
    public PersonDto getById(Integer id) {
        return this.personRepository.getPersonById(id);
    }

    @Override
    public PersonDto getByName(String name) {
        return this.personRepository.getPersonByName(name);
    }

    @Override
    public PersonDto getByDni(String dni) {
        return this.personRepository.getPersonByDni(dni);
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        return this.personRepository.savePerson(personDto);
    }

    @Override
    public PersonDto patch(Integer id, UpdatePersonDto updatePersonDto) {
        return this.personRepository.patchPerson(id,updatePersonDto);
    }

    @Override
    public void delete(Integer id) {
        this.personRepository.deletePersonById(id);
    }

    public void deleteByPersonDni(String personDni){
        this.personRepository.deletePersonByPersonDni(personDni);
    }
}
