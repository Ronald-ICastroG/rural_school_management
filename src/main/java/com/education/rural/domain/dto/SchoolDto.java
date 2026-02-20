package com.education.rural.domain.dto;


public record SchoolDto(

    long escId,
    String escName,
    String escDescription,
    String escAddress,
    String escFoundationDate,
    int escRanking,
    String escState
    ){}
