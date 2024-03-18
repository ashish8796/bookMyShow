package com.Ashish.BookMyShow.repository;

import com.Ashish.BookMyShow.model.Actor;
import com.Ashish.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    Actor findActorByName(String actorName);
}
