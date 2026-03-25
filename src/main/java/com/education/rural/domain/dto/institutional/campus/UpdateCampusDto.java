package com.education.rural.domain.dto.institutional.campus;

import jakarta.validation.constraints.NotBlank;
import jdk.jfr.BooleanFlag;

public record UpdateCampusDto (



    @NotBlank(message = "The firstName of the campus dont be a blank space or  null ")
    String campusName,

    String campusLocation,

    @BooleanFlag
    Boolean campusActive
    ){
    }
