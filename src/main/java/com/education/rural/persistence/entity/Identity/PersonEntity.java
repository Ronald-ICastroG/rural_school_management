package com.education.rural.persistence.entity.Identity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Per_Id")
    private Integer personId;

    @Column(name = "Per_Fname",length = 60)
    private String firstName;

    @Column(name = "Per_Lname",length = 60)
    private String lastName;

    @Column(name="Per_Dni",length = 20,unique = true)
    private String personDni;

    @Column(name = "Per_Birthdate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate personBirthdate;

    @OneToMany(mappedBy = "person")
    private List<ContactEntity> contacts;
}
