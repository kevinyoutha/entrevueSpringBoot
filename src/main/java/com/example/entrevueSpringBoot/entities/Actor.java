package com.example.entrevueSpringBoot.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;

@Data

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Film film;

}
