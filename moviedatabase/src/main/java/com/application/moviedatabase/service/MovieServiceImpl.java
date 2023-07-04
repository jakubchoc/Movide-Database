package com.application.moviedatabase.service;

import com.application.moviedatabase.dto.MovieDTO;
import com.application.moviedatabase.dto.mapper.MovieMapper;
import com.application.moviedatabase.entity.MovieEntity;
import com.application.moviedatabase.entity.filter.MovieFilter;
import com.application.moviedatabase.entity.PersonEntity;
import com.application.moviedatabase.entity.repository.MovieRepository;
import com.application.moviedatabase.entity.repository.PersonRepository;
import com.application.moviedatabase.entity.repository.specification.MovieSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        mapPeopleToMovie(movie, movieDTO);
        MovieEntity saved = movieRepository.save(movie);
        return movieMapper.toDTO(saved);
    }

    @Override
    public MovieDTO editMovie(Long movieId, MovieDTO movieDTO) {
        MovieEntity movie = movieRepository.getReferenceById(movieId);
        if (movie == null) {
            throw new EntityNotFoundException("Movie id: " + movieId + " doesnt exist");
        }
        movieDTO.setId(movieId);
        MovieEntity entity = movieRepository.getReferenceById(movieId);
        movieMapper.updateEntity(movieDTO, entity);

        mapPeopleToMovie(movie, movieDTO);
        MovieEntity saved = movieRepository.save(entity);
        return movieMapper.toDTO(saved);
    }

    @Override
    public MovieDTO deleteMovie(Long movieId) {
        MovieEntity movieEntity = movieRepository.getReferenceById(movieId);
        if (movieEntity == null) {
            throw new EntityNotFoundException("Movie id: " + movieId + " doesnt exist");
        }
        movieRepository.delete(movieEntity);
        MovieDTO movieDTO = movieMapper.toDTO(movieEntity);
        return  movieDTO;
    }

    @Override
    public List<MovieDTO> getAllMovies(MovieFilter movieFilter) {
        MovieSpecification movieSpecification = new MovieSpecification(movieFilter);

        return movieRepository.getFilteredMovies(movieSpecification, PageRequest.of(0, movieFilter.getLimit()))
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovie(Long id) {
        MovieEntity movie = movieRepository.getReferenceById(id);
        return movieMapper.toDTO(movie);
    }

    private void mapPeopleToMovie(MovieEntity movie, MovieDTO movieDTO){
        movie.setActors(new ArrayList<>());

        List<PersonEntity> people = personRepository.findAllById(movieDTO.getActorIDs());
        movie.getActors().addAll(people);
        movie.setDirector(personRepository.getReferenceById(movieDTO.getDirectorID()));
    }
}
