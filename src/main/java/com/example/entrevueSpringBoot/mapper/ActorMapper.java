package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.entities.Actor;
import com.example.entrevueSpringBoot.dto.ActorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring" , uses = FilmMapper.class)
public interface ActorMapper {


    @Mappings({
            @Mapping(target="id", source="actor.id"),
            @Mapping(target="prenom", source="actor.firstname"),
            @Mapping(target="nom", source="actor.lastname")
    })
    ActorDTO actorToActorDTO(Actor actor);

    Set<ActorDTO> actorToActorDTO(final Set<Actor> actor);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="firstname", source="dto.prenom"),
            @Mapping(target="lastname", source="dto.nom")
    })
    Actor actorDTOtoActor(ActorDTO dto);
}
