package com.application.moviedatabase.entity.repository;

import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(value = "SELECT * FROM person WHERE role = :role LIMIT :limit")
    Page<PersonEntity> getAllByRole(@Param("role") RoleType role, @Param("limit") int limit);
}
