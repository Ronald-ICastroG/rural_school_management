package com.education.rural.persistence.entity.Identity.specialization;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "teacher_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tpf_id")
    private Integer profileId;

    @Column(name = "tpf_profileName", nullable = false, length = 45)
    private String profileName;

    @Column(name = "tpf_profileDescription",length = 100)
    private String profileDescription;
}
