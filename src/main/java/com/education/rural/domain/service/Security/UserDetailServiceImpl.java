package com.education.rural.domain.service.Security;

import com.education.rural.persistence.repository.Security.user.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final JpaUserRepository jpaUserRepository;



    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return jpaUserRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found "+username));
    }
}
