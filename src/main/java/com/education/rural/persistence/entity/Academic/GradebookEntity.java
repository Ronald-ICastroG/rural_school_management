package com.education.rural.persistence.entity.Academic;

import com.education.rural.persistence.entity.Identity.specialization.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="gradebook")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradebookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Gbk_Id")
    private Integer gradebookId;

    @Column(name = "Gbk_Value")
    private Float gradebookValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Gbk_StuId")
    private StudentEntity studentEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="Gbk_AsiId")
    private AcademicAssignmentEntity assignmentEntity;
}
