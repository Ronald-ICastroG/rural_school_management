package com.education.rural.persistence.repository.Identity.person;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;
import com.education.rural.domain.repository.Identity.PersonRepository;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.mapper.Identity.PersonMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonEntityRepository implements PersonRepository {

    private final PersonMapper personMapper;
    private final JpaPersonRepository jpaPersonRepository;

    public PersonEntityRepository(PersonMapper personMapper, JpaPersonRepository jpaPersonRepository) {
        this.personMapper = personMapper;
        this.jpaPersonRepository = jpaPersonRepository;
    }


    @Override
    public List<PersonDto> getAllPersons() {
        return this.personMapper.PersonstoDto(this.jpaPersonRepository.findAll());
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        return this.personMapper.toDto(this.jpaPersonRepository.findById(id).orElseThrow(()->new RuntimeException("Person not found")));
    }

    @Override
    public PersonDto getPersonByName(String name) {
        return this.personMapper.toDto(this.jpaPersonRepository.findFirstByFirstNameIgnoreCase(name));
    }

    @Override
    public PersonDto getPersonByDni(String personDni) {
        return this.personMapper.toDto(this.jpaPersonRepository.findFirstByPersonDniIgnoreCase(personDni));
    }

    @Override
    public PersonDto savePerson(PersonDto personDto) {
        PersonEntity personEntity = this.personMapper.toEntity(personDto);
        PersonEntity savedPerson = jpaPersonRepository.save(personEntity);
        return this.personMapper.toDto(savedPerson);
    }


    @Override
    public PersonDto patchPerson(Integer id, UpdatePersonDto updatePersonDto) {
        PersonEntity personEntity=this.jpaPersonRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

        this.personMapper.UpdatePersonFromDto(updatePersonDto,personEntity);
        return this.personMapper.toDto(this.jpaPersonRepository.save(personEntity));

    }

    @Override
    public void deletePersonById(Integer id) {
        PersonEntity personEntity=this.jpaPersonRepository.findById(id).orElseThrow(()->new RuntimeException("Person not found"));
        this.jpaPersonRepository.deleteById(id);
    }

    public void deletePersonByPersonDni(String personDni){
        PersonEntity personEntity=this.jpaPersonRepository.findFirstByPersonDniIgnoreCase(personDni);
        this.jpaPersonRepository.deleteByPersonDni(personDni);
        System.out.println("Persona con dni "+personDni+" eliminada");
    }
}
