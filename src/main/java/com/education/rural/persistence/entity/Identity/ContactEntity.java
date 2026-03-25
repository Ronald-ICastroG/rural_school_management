package com.education.rural.persistence.entity.Identity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Con_Id")
    private Integer contactId;
    @Column(name = "Con_Phone",length = 20)
    private String contactPhone;
    @Column(name = "Con_Email",length = 100)
    private String contactEmail;
    @Column(name = "Con_Address",length = 100)
    private String contactAddress;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Con_PerId",nullable = false)
    private PersonEntity person;
}
