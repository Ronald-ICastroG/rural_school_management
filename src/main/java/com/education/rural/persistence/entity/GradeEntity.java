package com.education.rural.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Grade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Grd_Id")
    private Integer gradeId;

    @Column(name="Grd_Name",length=45)
    private String gradeName;

    @Column(name = "Grd_Active")
    private Boolean gradeActive=true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Grd_CamId",nullable = false,insertable = false, updatable = false)
    private CampusEntity campus;
}
