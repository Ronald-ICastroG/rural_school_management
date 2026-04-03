package com.education.rural.domain.service.Security;

import com.education.rural.domain.dto.Security.AuthResponse;
import com.education.rural.domain.dto.Security.LoginRequest;
import com.education.rural.domain.dto.Security.RegisterRequest;

public interface IAuthService {

    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
