package com.application.moviedatabase.controller;

import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.dto.PersonDTO;
import com.application.moviedatabase.service.PersonService;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/people")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @GetMapping("/actors")
    public List<PersonDTO> getActors(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return personService.getPeople(RoleType.actor, limit);
    }

    @GetMapping("/directors")
    public List<PersonDTO> getDirectors(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return personService.getPeople(RoleType.director, limit);
    }

    @GetMapping("/people/{personId}")
    public PersonDTO getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

    @PutMapping("/people/{personId}")
    public PersonDTO editPerson(@PathVariable Long personId, @RequestBody PersonDTO personDTO) {
        return personService.editPerson(personId, personDTO);
    }
}
