package fr.v0.minorease.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "hoteliers")
public class Hotelier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Company name cannot be empty")
    private String companyName;

    private String siretNumber;
    private String vatNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "hotelier")
    private List<Hotel> hotels;
}
