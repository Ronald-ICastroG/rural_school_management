package com.education.rural.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Campus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cam_Id")
    private Integer campusId;
    @Column(name = "Cam_Name",length = 45)
    private String campusName;
    @Column(name = "Cam_Location",length = 150)
    private String campusLocation;
    @Column(name = "Cam_Active")
    private Boolean campusActive=true;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name = "Cam_SchId",nullable = false)
    private SchoolEntity school;
    @OneToMany(mappedBy = "campus")
    private List<GradeEntity>grades;
}
