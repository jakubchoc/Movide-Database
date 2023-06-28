package com.application.moviedatabase.controller;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movie")
    public MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @PutMapping("/movie/{movieId}")
    public MovieDTO editMovie(@RequestParam Long movieId, @RequestBody MovieDTO movieDTO) {
        return movieService.editMovie(movieId, movieDTO);
    }

    public String[] getGenres() {
        return new String[] {"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }
}
