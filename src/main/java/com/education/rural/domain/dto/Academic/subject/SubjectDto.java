package com.education.rural.domain.dto.Academic.subject;

public record SubjectDto(
        Integer subjectId,
        String subjectName,
        String subjectDescription,
        Integer assignmentId
) {
}
