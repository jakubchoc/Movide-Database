package com.application.moviedatabase.controller;

import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.service.PersonService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @PostMapping({"/people/", "/people"})
    public void addPerson() {

    }

    @GetMapping({"/actors/", "/actors"})
    public List<PersonDTO> getActors(@RequestParam int limit) {
        return personService.getPeople(RoleType.ACTOR, limit);
    }

    @GetMapping({"/directors/", "/directors"})
    public List<PersonDTO> getDirectors(@RequestParam int limit) {
        return personService.getPeople(RoleType.DIRECTOR, limit);
    }

}
