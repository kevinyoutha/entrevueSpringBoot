package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.dto.FilmDTO;
import com.example.entrevueSpringBoot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class FilmController {

    @Autowired
    FilmService filmService;

    /**
     * Get a film with actors.
     *
     * <code>
     * GET http://localhost:8080/api/film/1
     * <code>
     * </code>
     * Response:
     * <code>
     *   {
     *      "id":1,
     *      "titre":"Star Wars: The Empire Strikes Back",
     *      "description":"Darth Vader is adamant about turning Luke Skywalker to the dark side.",
     *      "acteurs":[
     *          {
     *              "id":2,
     *              "nom":"Ford",
     *              "prenom":"Harrison"
     *          },
     *          {
     *              "id":3,
     *              "nom":"Hamill",
     *              "prenom":"Mark"
     *          }
     *      ]
     *  }
     * </code>
     * @param id The id of the film we are looking for.
     * @return The film if founded otherwise notfound code error
     */
    @GetMapping("/film/{id}")
    public ResponseEntity<FilmDTO> findById(@PathVariable Long id) {
       return filmService.findById(id);
    }

    /**
     * Persist a new film.
     *
     * <code>
     * POST http://localhost:8080/api/film
     * <code>
     * POST Body:
     * <code>
     * {
     *      "titre":"Star Wars: The Empire Strikes Back",
     *      "description":"Darth Vader is adamant about turning Luke Skywalker to the dark side.",
     *      "acteurs":[
     *          {
     *              "nom":"Ford",
     *              "prenom":"Harrison"
     *          },
     *          {
     *              "nom":"Hamill",
     *              "prenom":"Mark"
     *          }
     *      ]
     * }
     * </code>
     * Response:
     * <code>
     *   {
     *      "id":1,
     *      "titre":"Star Wars: The Empire Strikes Back",
     *      "description":"Darth Vader is adamant about turning Luke Skywalker to the dark side.",
     *      "acteurs":[
     *          {
     *              "id":2,
     *              "nom":"Ford",
     *              "prenom":"Harrison"
     *          },
     *          {
     *              "id":3,
     *              "nom":"Hamill",
     *              "prenom":"Mark"
     *          }
     *      ]
     *  }
     * </code>
     * @param filmDTO The new film to create.
     * @return The film after it has been stored.  This will include a unique ID for the film and the actors.
     */
    @PostMapping("/film")
    public ResponseEntity<FilmDTO> addFilm(@RequestBody FilmDTO filmDTO) {
        return filmService.addFilm(filmDTO);
    }

}
