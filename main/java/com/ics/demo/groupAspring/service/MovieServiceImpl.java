package com.ics.demo.groupAspring.service;

import com.ics.demo.groupAspring.NotFoundException;
import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Movie;
import com.ics.demo.groupAspring.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ActorService actorService;

    public MovieServiceImpl(MovieRepository movieRepository, ActorService actorService) {
        this.movieRepository = movieRepository;
        this.actorService = actorService;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()->
                new NotFoundException("No record with"+id+"found"));
    }

    @Override
    public Movie create(@Validated(Movie.Create.class)Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie update(@Validated(Movie.Update.class) Movie movie) {
        Movie foundMovie = findById(movie.getId());
        foundMovie.setName(movie.getName());
        foundMovie.setYear(movie.getYear());
        return movieRepository.save(foundMovie);
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie foundMovie = findById(movie.getId());
        foundMovie.setName(movie.getName());
        foundMovie.setYear(movie.getYear());
        return movieRepository.save(foundMovie);
    }

    @Override
    public Actor createActor(Long id, Actor actor) {
        Movie movie = findById(id);
        actor.setMovie(movie);
        return actorService.create(actor);
    }
}
