package com.education.rural.domain.dto.Identity.specialization.teacher;

public record TeacherDto(
        Integer teacherId,
        Boolean teacherActive,
        Integer profileId,
        Integer personId
) {
}
