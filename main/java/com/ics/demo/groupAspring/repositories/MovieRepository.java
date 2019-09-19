package com.ics.demo.groupAspring.repositories;

import com.ics.demo.groupAspring.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
