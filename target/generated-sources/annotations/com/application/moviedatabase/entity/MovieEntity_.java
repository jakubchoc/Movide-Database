package com.application.moviedatabase.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MovieEntity.class)
public abstract class MovieEntity_ {

	public static volatile ListAttribute<MovieEntity, PersonEntity> actors;
	public static volatile SingularAttribute<MovieEntity, Boolean> isAvailable;
	public static volatile SingularAttribute<MovieEntity, Integer> year;
	public static volatile SingularAttribute<MovieEntity, PersonEntity> director;
	public static volatile ListAttribute<MovieEntity, String> genres;
	public static volatile SingularAttribute<MovieEntity, String> name;
	public static volatile SingularAttribute<MovieEntity, Long> id;
	public static volatile SingularAttribute<MovieEntity, LocalDate> dateAdded;

	public static final String ACTORS = "actors";
	public static final String IS_AVAILABLE = "isAvailable";
	public static final String YEAR = "year";
	public static final String DIRECTOR = "director";
	public static final String GENRES = "genres";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String DATE_ADDED = "dateAdded";

}

