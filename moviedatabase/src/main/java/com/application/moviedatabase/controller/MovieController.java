package com.application.moviedatabase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {

    public String[] getGenres() {
        return new String[] {"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }
}
