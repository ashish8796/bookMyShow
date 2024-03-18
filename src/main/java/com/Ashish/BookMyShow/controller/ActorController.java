package com.Ashish.BookMyShow.controller;


import com.Ashish.BookMyShow.dto.ActorRequestDTO;
import com.Ashish.BookMyShow.model.Actor;
import com.Ashish.BookMyShow.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping("/{name}")
    public ResponseEntity getActorByName(@PathVariable("name") String actorName) {
        Actor actor = actorService.getActorByName(actorName);
        return ResponseEntity.ok(actor);
    }

    @PostMapping("/save")
    public ResponseEntity createActor(@RequestBody ActorRequestDTO actorRequestDTO) {
        Actor actor = actorService.saveActor(actorRequestDTO.getName());

        return ResponseEntity.ok(actor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteActor(@PathVariable("id") int actorId) {
        boolean isDeleted = actorService.deleteActor(actorId);
        return ResponseEntity.ok(isDeleted);
    }
}
