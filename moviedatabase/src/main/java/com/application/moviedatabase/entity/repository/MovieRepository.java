package com.application.moviedatabase.entity.repository;

import com.application.moviedatabase.entity.MovieEntity;
import com.application.moviedatabase.entity.MovieFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieRepository extends PagingAndSortingRepository<MovieEntity, Long>, JpaRepository<MovieEntity, Long> {

    MovieEntity findByName(String movieName);

    @Query(value = "SELECT m FROM movie m WHERE" +
            "    (:#{#filter.getFromYear()} is null OR m.year >= :#{#filter.getFromYear()}) " +
            "AND (:#{#filter.getToYear()} is null OR m.year <= :#{#filter.getToYear()})  " +
            "AND (:#{#filter.getActorID()} = -1 OR :#{#filter.getActorID()} IN (SELECT a.id FROM m.actors a)) " +
            "AND (:#{#filter.getGenre()} = '' OR :#{#filter.getGenre()} IN (SELECT g FROM m.genres g))"
    )
    List<MovieEntity> getFilteredMovies(MovieFilter movieFilter, Pageable pageable);
}
