package com.education.rural.domain.dto.Academic.Gradebook;

public record GradebookDto(
        Integer gradebookId,
        Float gradebookValue,
        Integer studentId,
        Integer assignmentId
) {
}
