package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.entities.Actor;
import com.example.entrevueSpringBoot.entities.Film;
import com.example.entrevueSpringBoot.dto.FilmDTO;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", uses = ActorMapper.class)
public interface FilmMapper {

    @Mappings({
            @Mapping(target="id", source="film.id"),
            @Mapping(target="titre", source="film.title"),
            @Mapping(target="description", source="film.description"),
            @Mapping(target="acteurs", source="film.actors"),
    })
    FilmDTO filmToFilmDTO(Film film);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="title", source="dto.titre"),
            @Mapping(target="description", source="dto.description"),
            @Mapping(target="actors", source="dto.acteurs")
    })
    Film filmDTOtoFilm(FilmDTO dto);

}
