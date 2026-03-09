package com.education.rural.domain.dto;

import com.education.rural.persistence.entity.GradeEntity;
import com.education.rural.persistence.entity.SchoolEntity;
import jakarta.persistence.*;

import java.util.List;

public record CampusDto (

    Integer campusId,

    String campusName,
    String campusLocation,

    Boolean campusActive,

    Integer schoolId,

    List<Integer> gradesIds
    ){
}
