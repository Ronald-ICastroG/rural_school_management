package com.education.rural.persistence.entity.Security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Rol_Id")
    private Integer roleId;
    @Column(name = "Rol_Name",length = 10)
    private String roleName;
    @Column(name = "Rol_Active")
    private Boolean roleActive;
}
