package com.education.rural.persistence.entity.Identity.specialization;

import com.education.rural.persistence.entity.Identity.PersonEntity;
import com.education.rural.persistence.entity.Institutional.GradeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_id")
    private Integer studentId;

    @Column(name="stu_enrollment", nullable=false)
    private LocalDate studentEnrollment;

    @Column(name = "stu_active",columnDefinition = "Boolean")
    private Boolean studentActive;

    @ManyToOne
    @JoinColumn(name = "Person_Per_Id")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "Grade_grade_Id")
    private GradeEntity grade;


}
