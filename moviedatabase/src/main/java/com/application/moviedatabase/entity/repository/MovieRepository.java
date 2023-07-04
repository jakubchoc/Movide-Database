package com.application.moviedatabase.entity.repository;

import com.application.moviedatabase.entity.MovieEntity;
import com.application.moviedatabase.entity.repository.specification.MovieSpecification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> , JpaSpecificationExecutor<MovieEntity> {

    MovieEntity findByName(String movieName);

    //List<MovieEntity> getFilteredMovies(MovieSpecification movieSpecification, Pageable pageable);
}
