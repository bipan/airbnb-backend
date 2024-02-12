package com.pw.airbnb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rId")
    private Long id;
    @NotBlank
    private String reservationDate;
    @NotBlank
    private String checkIn;
    @NotBlank
    private String checkOut;
    @NotBlank
    private Integer numberOfGuest;
}
