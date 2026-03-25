package com.education.rural.domain.dto.institutional.school;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UpdateSchoolDto(
        @NotBlank(message = "The firstName of the school cansnot be left blank.")
        String escName,
        String escDescription,
        String escAddress,
        @Positive(message = "The ranking should be a positive number")
        int escRanking,
        String escState
) {

}
