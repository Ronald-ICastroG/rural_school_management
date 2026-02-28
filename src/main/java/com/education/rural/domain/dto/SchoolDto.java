package com.education.rural.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record SchoolDto(

    long escId,
    @NotBlank(message = "The name of the school cannot be left blank.")
    String escName,
    String escDescription,
    String escAddress,
    @PastOrPresent(message="The date cannot be later than the current date.")
    String escFoundationDate,
    @Positive(message = "The ranking should be a positive number")
    int escRanking,
    String escState
    ){}
