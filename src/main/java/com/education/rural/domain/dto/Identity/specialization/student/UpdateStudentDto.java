package com.education.rural.domain.dto.Identity.specialization.student;

import org.mapstruct.ap.shaded.freemarker.ext.beans.BooleanModel;

import java.time.LocalDate;

public record UpdateStudentDto(
        LocalDate studentEnrollment,
        Boolean studentActive
) {
}
