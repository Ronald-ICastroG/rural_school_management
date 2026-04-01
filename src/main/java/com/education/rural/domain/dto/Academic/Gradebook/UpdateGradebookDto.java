package com.education.rural.domain.dto.Academic.Gradebook;

public record UpdateGradebookDto(
        Float gradebookValue,
        Integer studentId,
        Integer assignmentId
) {
}
