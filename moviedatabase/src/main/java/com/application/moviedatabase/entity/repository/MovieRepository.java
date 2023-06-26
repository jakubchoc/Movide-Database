package com.application.moviedatabase.entity.repository;

import com.application.moviedatabase.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
