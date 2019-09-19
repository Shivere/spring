package com.ics.demo.groupAspring.models;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name")
    @NotNull(groups = Create.class)
    private String name;

    @Column(name = "year_released")
    private String yearReleased;

    public Movie(String name, String yearReleased) {
        this.name = name;
        this.yearReleased = yearReleased;
    }
    private Movie(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return yearReleased;
    }

    public void setYear(String year) {
        this.yearReleased = year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @OneToMany(mappedBy = "movie")
    private List<Actor> actors;

    @ManyToMany(mappedBy = "movies")
    private Set<Category> categories;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearReleased='" + yearReleased + '\'' +
                ", actors=" + actors +
                ", categories=" + categories +
                '}';
    }

    public interface Create{}

    public interface Update{}
}
