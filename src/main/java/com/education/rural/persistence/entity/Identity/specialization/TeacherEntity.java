package com.education.rural.persistence.entity.Identity.specialization;


import com.education.rural.persistence.entity.Academic.AcademicAssignmentEntity;
import com.education.rural.persistence.entity.Identity.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tea_Id")
    private Long teacherId;

    @Column(name = "Tea_Active")
    private Boolean teacherActive=true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Tea_TpfId")
    private TeacherProfileEntity teacherProfileEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tea_PerId")
    private PersonEntity personEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Tea_AsiId")
    private AcademicAssignmentEntity assignmentEntity;

}
