package com.education.rural.domain.dto.Security;

public record LoginRequest(
        String userName,
        String userPassword
) {
}
