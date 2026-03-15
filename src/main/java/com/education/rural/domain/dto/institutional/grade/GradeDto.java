package com.education.rural.domain.dto.institutional.grade;

public record GradeDto(

         Integer gradeId,
            String gradeName,
            Boolean gradeActive,

        Integer campusId
) {
}
