package com.ics.demo.groupAspring.repositories;

import com.ics.demo.groupAspring.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
