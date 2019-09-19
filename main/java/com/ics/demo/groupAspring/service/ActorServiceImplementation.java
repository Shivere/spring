package com.ics.demo.groupAspring.service;

import com.ics.demo.groupAspring.NotFoundException;
import com.ics.demo.groupAspring.models.Actor;
import com.ics.demo.groupAspring.repositories.ActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class ActorServiceImplementation implements ActorService{
    private final ActorRepository actorRepository;

    public ActorServiceImplementation(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id).orElseThrow(()->new NotFoundException("No record with "+id+" found"));
    }

    @Override
    public Actor create(@Validated(Actor.Create.class) Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public Actor update(@Validated(Actor.update.class) Actor actor) {
        Actor foundActor =findById(actor.getId());
        foundActor.setName(actor.getName());
        foundActor.setYearBorn(actor.getYearBorn());
        return actorRepository.save(foundActor);
    }

    @Override
    public Actor update(Long id, Actor actor) {
        Actor foundActor =findById(actor.getId());
        foundActor.setName(actor.getName());
        foundActor.setYearBorn(actor.getYearBorn());
        return actorRepository.save(foundActor);
    }
}
