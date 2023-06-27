package fr.v0.minorease.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "parents")
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstname;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Email
    private String childEmail;

    private String identityCardFile;

    private String familyBookFile;

    private String billingAddress;

    private String phoneNumber;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}
