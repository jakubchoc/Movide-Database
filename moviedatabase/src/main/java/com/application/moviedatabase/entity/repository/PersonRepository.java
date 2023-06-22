package com.application.moviedatabase.entity.repository;

import com.application.moviedatabase.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
