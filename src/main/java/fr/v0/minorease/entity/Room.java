package fr.v0.minorease.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer capacity;

    private Double price;

    private String image;

    private String description;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
