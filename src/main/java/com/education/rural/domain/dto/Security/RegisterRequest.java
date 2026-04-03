package com.education.rural.domain.dto.Security;

public record RegisterRequest(
        String userName,
        String userPassword,
        Integer personId,
        Integer roleId
) {
}
