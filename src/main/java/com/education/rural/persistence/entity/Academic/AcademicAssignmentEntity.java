package com.education.rural.persistence.entity.Academic;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Entity
@Table(name="academic_assignment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Asi_Id")
    private Integer assignmentId;

    @Column(name = "Asi_Year")
    private Integer assignmentYear;


}
