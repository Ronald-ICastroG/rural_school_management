package com.education.rural.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="escuela")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EscId;


    @Column(name = "esc_name", nullable = false,length=150)
    private String EscName;

    @Column(name = "esc_description", nullable = false,length=150)
    private String EscDescription;

    @Column(name = "esc_foundation")
    private LocalDate EscFoundationDate;

    @Column(name = "esc_ranking")
    private BigDecimal escRanking;

    @Column(nullable = false,length=1)
    private String estado;

}
