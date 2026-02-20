package com.education.rural.domain.dto;


import com.education.rural.persistence.entity.SchoolEntity;

import java.util.List;

public record SchoolDto(

    long Escid,
    String EscName,
    String EscDescription,
    String EscAddress,
    String EscFoundationDate,
    int EscRanking,
    String state
    ){}
