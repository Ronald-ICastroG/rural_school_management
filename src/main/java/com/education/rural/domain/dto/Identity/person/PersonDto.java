package com.education.rural.domain.dto.Identity.person;

import java.time.LocalDate;
import java.util.List;

public record PersonDto (
        Integer personId,
        String firstName,
        String lastName,
        String personDni,
        LocalDate personBirthdate,
        List<Integer>contactIds

){
}
