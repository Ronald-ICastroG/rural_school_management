package com.education.rural.domain.dto.Identity.specialization.staff;

public record UpdateStaffDto (
        String staffPosition,
        Long schoolId,
        Integer campusId
        ){
}
