package com.education.rural.persistence.repository.Security.user;

import com.education.rural.persistence.entity.Security.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity,Integer> {
    @Transactional
    Optional<UserEntity> findByUserName(String userName);
}
