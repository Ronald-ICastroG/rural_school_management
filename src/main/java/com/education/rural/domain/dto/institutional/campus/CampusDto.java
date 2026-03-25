package com.education.rural.domain.dto.institutional.campus;

import jakarta.validation.constraints.NotBlank;
import jdk.jfr.BooleanFlag;

import java.util.List;

public record CampusDto (

    Integer campusId,


    @NotBlank(message = "Not be a null or white campus firstName")
    String campusName,

    String campusLocation,

    @BooleanFlag
    Boolean campusActive,

    Integer schoolId,

    List<Integer> gradesIds
    ){
}
