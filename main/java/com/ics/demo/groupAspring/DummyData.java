package com.ics.demo.groupAspring;

import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.models.Category;
import com.ics.demo.groupAspring.models.Movie;
import com.ics.demo.groupAspring.repositories.ActorRepository;
import com.ics.demo.groupAspring.repositories.CategoryRepository;
import com.ics.demo.groupAspring.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DummyData implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final CategoryRepository categoryRepository;


    public DummyData(MovieRepository movieRepository, ActorRepository actorRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = categoryRepository.save(new Category("Science Fiction")); //new Category("Science Fiction");
        Category category1 = categoryRepository.save(new Category("Thriller"));//new Category("Thriller");
        Set<Category> categories = new HashSet<>();

        Movie movie = new Movie("Fast and Slow", "1990");
        movieRepository.save(movie);


        Movie movie1 = new Movie("Slow and Fast", "1989");
        movieRepository.save(movie1);

//        Actor actor = new Actor("Shivere", 2000, Movie:Wick;

    }
}
