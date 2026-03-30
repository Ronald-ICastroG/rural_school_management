package com.education.rural.domain.dto.Identity.specialization.student;

import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record StudentDto(

        Integer studentId,
        @PastOrPresent
        LocalDate studentEnrollment,
        Integer personId,
        Integer gradeId,
        Boolean studentActive
) {
}
