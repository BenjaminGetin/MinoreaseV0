package fr.v0.minorease.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String country;

    private String city;

    private String location;

    private String image;

    private Double rating;

    private String description;

    private Integer star;

    private String webSite;

    @ManyToOne
    @JoinColumn(name = "hotelier_id")
    private Hotelier hotelier;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
