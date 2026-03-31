package com.education.rural.persistence.entity.Identity.specialization;


import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Institutional.CampusEntity;
import com.education.rural.persistence.entity.Institutional.SchoolEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;

@Entity
@Table(name="Staff")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Stf_Id")
    private Integer staffId;
    @Column(name = "Stf_Position")
    private String staffPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Stf_PerId")
    private PersonEntity personEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Stf_EscId")
    private SchoolEntity schoolEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Stf_camId")
    private CampusEntity campusEntity;
}
