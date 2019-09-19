package com.ics.demo.groupAspring.service;

import com.ics.demo.groupAspring.models.Actor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(Long id);
    Actor create(Actor actor);
    void delete(Long id);
    Actor update(Actor actor);
    Actor update(Long id, Actor actor);

}
