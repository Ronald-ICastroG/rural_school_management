package com.education.rural.persistence.entity.Security;

import com.education.rural.persistence.entity.Identity.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Usr_Id")
    private Integer userId;
    @Column(name = "Usr_Name",length = 45)
    private String userName;
    @Column(name="Usr_Password",length = 100)
    private String userPassword;
    @Column(name = "Usr_Active")
    private Boolean userActive;

    @ManyToOne
    @JoinColumn(name = "Usr_PerId")
    private PersonEntity personEntity;

    @ManyToMany
    @JoinTable(
            name = "User_has_Role",
            joinColumns = @JoinColumn(name = "User_UsrId"),
            inverseJoinColumns = @JoinColumn(name = "Role_RolId")
    )
    private List<RoleEntity> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

