package com.education.rural.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esc_id")
    private long escId;
    @Column(name = "esc_name", nullable = false,length=150)
    private String escName;
    @Column(name = "esc_description", nullable = false,length=150)
    private String escDescription;
    @Column(name = "esc_address", nullable = false,length=200)
    private String escAddress;
    @Column(name = "esc_foundation")
    private LocalDate escFoundationDate;
    @Column(name = "esc_ranking")
    private int escRanking;
    @Column(nullable = false,length=1)
    private String escState;

}
