package com.application.moviedatabase.controller;

import com.application.moviedatabase.configuration.GenreConfiguration;
import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.entity.filter.MovieFilter;
import com.application.moviedatabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;
    private final GenreConfiguration genreConfiguration;

    @GetMapping("/movie/{movieId}")
    public MovieDTO getMovie(@PathVariable Long movieId) {
        return movieService.getMovie(movieId);
    }

    @GetMapping("/movies")
    public List<MovieDTO> getAllMovies(@RequestBody MovieFilter movieFilter) {
        return movieService.getAllMovies(movieFilter);
    }

    @Secured("USER")
    @PostMapping("/movie")
    public MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @Secured("ADMIN")
    @PutMapping("/movie/{movieId}")
    public MovieDTO editMovie(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO) {
        return movieService.editMovie(movieId, movieDTO);
    }

    @Secured("ADMIN")
    @DeleteMapping("/movie/{movieId}")
    public MovieDTO deleteMovie(@PathVariable Long movieId) {
        return movieService.deleteMovie(movieId);
    }

    @GetMapping("/genres")
    public List<String> getGenres() {
        return genreConfiguration.getGenres();
    }
}
