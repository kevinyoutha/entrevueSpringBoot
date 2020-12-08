package com.example.entrevueSpringBoot.dto;

import lombok.Data;
import java.util.Set;

@Data
public class FilmDTO  {
    private Long id;
    private String titre;
    private String description;
    private Set<ActorDTO> acteurs;


}
