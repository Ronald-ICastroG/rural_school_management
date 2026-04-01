package com.education.rural.persistence.entity.Academic;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sub_Id")
    private Integer subjectId;
    @Column(name = "Sub_Name",length = 45)
    private String subjectName;
    @Column(name = "Sub_Description",length = 100)
    private String subjectDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sub_AsiId")
    private AcademicAssignmentEntity assignmentEntity;


}
