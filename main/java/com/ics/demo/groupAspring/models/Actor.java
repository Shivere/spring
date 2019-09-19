package com.ics.demo.groupAspring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.sql.Update;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name")
    @NotNull(groups = Create.class)
    private String name;

    @Column(name = "year_born")
    private String yearBorn;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id_fk")
    private Movie movie;

    public Actor(String name, String year, Movie movie){
        this.name = name;
        this.yearBorn = year;
        this.movie = movie;
    }
    private Actor(){

    }

    public Long getId(){
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

    public String getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(String yearBorn) {
        this.yearBorn = yearBorn;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public interface Create{}

    public interface update{}
}
