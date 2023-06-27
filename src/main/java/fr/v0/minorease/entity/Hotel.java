package fr.v0.minorease.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "hotels")
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hotel_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    private String location;

    @Column(nullable = false)
    private String email;

    private String image;

    private Double rating;

    private Integer star;

    private String webSite;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
