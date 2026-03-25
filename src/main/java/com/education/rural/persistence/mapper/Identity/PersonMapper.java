package com.education.rural.persistence.mapper.Identity;

import com.education.rural.domain.dto.Identity.person.PersonDto;
import com.education.rural.domain.dto.Identity.person.UpdatePersonDto;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {


    List<PersonDto> PersonstoDto(Iterable<PersonEntity> entities);


    @Mapping(target="contacts",ignore = true)
    PersonEntity toEntity(PersonDto dto);

    @InheritInverseConfiguration
    PersonDto toDto(PersonEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "contacts",ignore = true)
    @Mapping(target="personId",ignore = true)
    void UpdatePersonFromDto(UpdatePersonDto updatePersonDto, @MappingTarget PersonEntity entity);
}
