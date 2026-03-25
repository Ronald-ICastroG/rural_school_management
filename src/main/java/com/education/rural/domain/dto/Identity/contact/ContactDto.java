package com.education.rural.domain.dto.Identity.contact;

public record ContactDto(

        Integer contactId,
        String contactPhone,
        String contactEmail,
        String contactAddress,
        Integer personId

) {
}
