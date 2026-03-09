package com.education.rural.persistence.mapper;

import com.education.rural.domain.dto.CampusDto;
import com.education.rural.persistence.entity.CampusEntity;
import com.education.rural.persistence.entity.SchoolEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CampusMapper {

    List<CampusDto> toDto(Iterable<CampusEntity> campusEntities);

    @Mapping(target="school.escId",source="schoolId")
    @Mapping(target="grades",ignore=true)
    CampusEntity toEntity(CampusDto dto);

    @InheritInverseConfiguration
    @Mapping(target="schoolId",source = "school.escId")
    @Mapping(target = "gradesIds", expression = "java(entity.getGrades() != null ? " +
            "entity.getGrades().stream().map(g -> g.getGradeId()).toList() : null)")
    CampusDto toDto(CampusEntity entity);

    @Named("idToSchool")
    default SchoolEntity idToSchool(Long schoolId) {
        if (schoolId == null) return null;
        SchoolEntity school = new SchoolEntity();
        school.setEscId(schoolId); // Asegúrate que el setter en SchoolEntity sea público
        return school;
    }

}
