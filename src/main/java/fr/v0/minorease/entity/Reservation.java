package fr.v0.minorease.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    private LocalDate arrivalDate;

    private LocalDate departureDate;

    private String dischargeFilePath;

    @Column(unique = true)
    private String reservationNumber;

    private BigDecimal priceHT;

    private BigDecimal priceTTC;

    @Column(unique = true)
    private String accessCode;
}
