package com.application.moviedatabase.controller;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.entity.filter.MovieFilter;
import com.application.moviedatabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public MovieDTO editMovie(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO) {
        return movieService.editMovie(movieId, movieDTO);
    }

    @DeleteMapping("/movie/{movieId}")
    public MovieDTO deleteMovie(@PathVariable Long movieId) {
        return movieService.deleteMovie(movieId);
    }

    @GetMapping("/movie/{movieId}")
    public List<MovieDTO> deleteMovie(@RequestBody MovieFilter movieFilter) {
        return movieService.getAllMovies(movieFilter);
    }

    public String[] getGenres() {
        return new String[] {"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }
}
