package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.dto.mapper.MovieMapper;
import com.application.moviedatabase.entity.MovieEntity;
import com.application.moviedatabase.entity.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = movieMapper.toEntity(movieDTO);
        movieRepository.save(movieEntity);
        MovieDTO result = movieMapper.toDTO(movieEntity);
        return result;
    }
}
