package com.education.rural.persistence.repository.Security.role;

import com.education.rural.persistence.entity.Security.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoleRepository extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity> findByRoleName(String roleName);
}
