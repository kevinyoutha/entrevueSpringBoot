package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.dto.FilmDTO;
import com.example.entrevueSpringBoot.entities.Film;
import com.example.entrevueSpringBoot.mapper.ActorMapper;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.repository.ActorRepository;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmMapper filmMapper;



    /**
     * retrieve a film along with actors
     */
    public ResponseEntity<FilmDTO> findById(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        ResponseEntity response;
        if ( optionalFilm.isPresent()){
            Film film = optionalFilm.get();
            film.getActors();
            response = ResponseEntity.ok(filmMapper.filmToFilmDTO(film));
        }else{
            response = ResponseEntity.notFound().build();
        }

        return response;
    }

    /**
     * Create a new film along with actors
     */
    @Transactional
    public ResponseEntity<FilmDTO> addFilm(FilmDTO filmDTO) {
        final Film film = filmMapper.filmDTOtoFilm(filmDTO);
        final Film createdFilm = filmRepository.save(film);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmMapper.filmToFilmDTO(createdFilm));
    }

}
