package com.education.rural.domain.service.Security;

import com.education.rural.domain.dto.Security.AuthResponse;
import com.education.rural.domain.dto.Security.LoginRequest;
import com.education.rural.domain.dto.Security.RegisterRequest;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Security.RoleEntity;
import com.education.rural.persistence.entity.Security.UserEntity;
import com.education.rural.persistence.repository.Identity.person.JpaPersonRepository;
import com.education.rural.persistence.repository.Security.role.JpaRoleRepository;
import com.education.rural.persistence.repository.Security.user.JpaUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthService implements IAuthService{

    private final JpaUserRepository jpaUserRepository;
    private final JpaRoleRepository jpaRoleRepository;
    private final JpaPersonRepository jpaPersonRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(JpaUserRepository jpaUserRepository, JpaRoleRepository jpaRoleRepository, JpaPersonRepository jpaPersonRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jpaUserRepository = jpaUserRepository;
        this.jpaRoleRepository = jpaRoleRepository;
        this.jpaPersonRepository = jpaPersonRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public AuthResponse register(RegisterRequest request) {

        PersonEntity person = jpaPersonRepository.findById(request.personId())
                .orElseThrow(()->new RuntimeException("person not found"));

        RoleEntity role = this.jpaRoleRepository.findById(request.roleId())
                .orElseThrow(()->new RuntimeException("role not found"));


        UserEntity user=new UserEntity();
            user.setUserName(request.userName());
            user.setUserPassword(passwordEncoder.encode(request.userPassword()));
            user.setUserActive(true);
            user.setPersonEntity(person);
            user.setRoles(List.of(role));

            jpaUserRepository.save(user);


        return new AuthResponse(jwtService.generateToken(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.userName(),
                        request.userPassword()
                )
        );


        UserEntity user = this.jpaUserRepository.findByUserName(request.userName())
                .orElseThrow(()->new RuntimeException("User not found"));
        return new AuthResponse(jwtService.generateToken(user));
    }
}
