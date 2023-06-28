package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO);

    MovieDTO editMovie(Long movieId, MovieDTO movieDTO);

    List<MovieDTO> getAllMovies();

    MovieDTO getMovie(Long id);
}
