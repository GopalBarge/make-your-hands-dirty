package com.make.your.hands.dirty.common.service;

import com.make.your.hands.dirty.common.modal.Tutorial;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.make.your.hands.dirty.common.Constants.tutorials;

@Service
public class TutorialService {


    public List<Tutorial> findAll() {
              return tutorials;
    }

    public List<Tutorial> findByTitleContaining(String title) {
        return tutorials.stream().filter(tutorial -> tutorial.title().contains(title)).toList();
    }

    public Optional<Tutorial> findById(long id) {
        return tutorials.stream().filter(tutorial -> id == tutorial.id()).findAny();
    }

    public Tutorial save(Tutorial tutorial) {
        tutorials.add(tutorial);
        return tutorial;
    }

    public void deleteById(long id) {
        tutorials.removeIf(tutorial -> id == tutorial.id());
    }

   private void populateTutorials(){
        tutorials.add(new Tutorial(1,"Reverse String", """
                Hello this is
                multiline
                description.               
                """, true));
    }
}
