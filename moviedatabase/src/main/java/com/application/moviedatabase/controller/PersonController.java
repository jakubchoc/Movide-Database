package com.application.moviedatabase.controller;

import com.application.moviedatabase.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @PostMapping({"/people/", "/people"})
    public void addPerson() {

    }
}
