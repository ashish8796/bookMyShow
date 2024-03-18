package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.Actor;
import com.Ashish.BookMyShow.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public Actor getActorByName(String actorName) {
        return actorRepository.findActorByName(actorName);
    }

    public Actor saveActor(String actorName) {
        Actor actor = new Actor();
        actor.setName(actorName);
        actor.setMovies(new ArrayList<>());

        return actorRepository.save(actor);
    }

    public Actor getActorById(int actorId) {
        return actorRepository.findById(actorId).get();
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public boolean deleteActor(int actorId) {
        actorRepository.deleteById(actorId);
        return true;
    }
}
