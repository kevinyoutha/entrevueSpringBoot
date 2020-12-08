package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Set<Actor> findByFilmId(Long filmId);

}
