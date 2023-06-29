package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.entity.MovieFilter;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO);

    MovieDTO editMovie(Long movieId, MovieDTO movieDTO);

    MovieDTO deleteMovie(Long movieId);

    List<MovieDTO> getAllMovies(MovieFilter movieFilter);

    MovieDTO getMovie(Long id);
}
