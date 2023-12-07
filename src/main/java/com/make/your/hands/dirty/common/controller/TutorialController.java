package com.make.your.hands.dirty.common.controller;

import com.make.your.hands.dirty.common.modal.Tutorial;
import com.make.your.hands.dirty.common.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {

        List<Tutorial> tutorials;

        if (title == null) {
            tutorials = tutorialService.findAll();
        } else {
            tutorials = tutorialService.findByTitleContaining(title);
        }
        return new ResponseEntity<>(tutorials, tutorials.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        if (tutorialService.findById(tutorial.id()).isEmpty()) {
            return new ResponseEntity<>(tutorialService.save(tutorial), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        tutorialService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
