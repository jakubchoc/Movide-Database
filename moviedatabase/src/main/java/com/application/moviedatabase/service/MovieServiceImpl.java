package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.dto.mapper.MovieMapper;
import com.application.moviedatabase.entity.MovieEntity;
import com.application.moviedatabase.entity.repository.MovieRepository;
import com.application.moviedatabase.entity.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = movieRepository.findByName(movieDTO.getName());
        if (movieEntity != null) {
            throw new EntityNotFoundException("Movie of name:  " + movieDTO.getName() + " already exist");
        }
        MovieEntity movie = movieMapper.toEntity(movieDTO);
        movie.setActors(new ArrayList<>());
        for (Long actorId : movieDTO.getActorIDs()) {
            movie.getActors().add(personRepository.getReferenceById(actorId));
        }
        movie.setDirector(personRepository.getReferenceById(movieDTO.getDirectorID()));
        MovieEntity saved = movieRepository.save(movie);
        return movieMapper.toDTO(saved);
    }

    @Override
    public MovieDTO editMovie(Long movieId, MovieDTO movieDTO) {
        if (!movieRepository.existsById(movieId)) {
            throw new EntityNotFoundException("Movie with id " + movieId + " not found");
        }
        MovieEntity entity = movieMapper.toEntity(movieDTO);
        entity.setId(movieId);
        MovieEntity saved = movieRepository.save(entity);
        return movieMapper.toDTO(saved);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> result = new ArrayList<>();
        for (MovieEntity movie : movieRepository.findAll()){
            result.add(movieMapper.toDTO(movie));
        }
        return result;
    }

    @Override
    public MovieDTO getMovie(Long id) {
        MovieEntity movie = movieRepository.getReferenceById(id);
        return movieMapper.toDTO(movie);
    }
}
