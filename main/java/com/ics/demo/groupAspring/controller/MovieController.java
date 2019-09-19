package com.ics.demo.groupAspring.controller;

import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Movie;
import com.ics.demo.groupAspring.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping(value = "{id}")
    public Movie findById(@PathVariable Long id){
        return movieService.findById(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie){
        return movieService.create(movie);
    }
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
     movieService.delete(id);
    }
    @PatchMapping
    public Movie update(@RequestBody Movie movie){
        return movieService.update(movie);
    }
    @PatchMapping(value = "{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie){
        return movieService.update(movie);
    }

    @PostMapping(value = "{id}/actors")
    public Actor create(@PathVariable Long id, @RequestBody Actor actor){
        return movieService.createActor(id,actor);
    }
}
