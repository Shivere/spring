package com.ics.demo.groupAspring.service;

import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie create(Movie movie);
    void delete(Long id);
    Movie update(Movie movie);
    Movie update(Long id, Movie movie);

    Actor createActor(Long id, Actor actor);
}
