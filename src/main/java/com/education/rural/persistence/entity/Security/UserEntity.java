package com.education.rural.persistence.entity.Security;

import com.education.rural.persistence.entity.Identity.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

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
}
