package com.example.entrevueSpringBoot.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
    @OneToMany(
            targetEntity = Actor.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "film_id")
    private Set<Actor> actors;



}
