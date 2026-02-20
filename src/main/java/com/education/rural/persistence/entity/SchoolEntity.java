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
    private long EscId;
    @Column(name = "esc_name", nullable = false,length=150)
    private String EscName;
    @Column(name = "esc_description", nullable = false,length=150)
    private String EscDescription;
    @Column(name = "esc_address", nullable = false,length=200)
    private String EscAddress;
    @Column(name = "esc_foundation")
    private LocalDate EscFoundationDate;
    @Column(name = "esc_ranking")
    private int EscRanking;
    @Column(nullable = false,length=1)
    private String EscEstate;

}
