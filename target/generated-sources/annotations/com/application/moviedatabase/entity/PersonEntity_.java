package com.application.moviedatabase.entity;

import com.application.moviedatabase.constant.RoleType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonEntity.class)
public abstract class PersonEntity_ {

	public static volatile SingularAttribute<PersonEntity, String> country;
	public static volatile SingularAttribute<PersonEntity, RoleType> role;
	public static volatile ListAttribute<PersonEntity, MovieEntity> actedInMovies;
	public static volatile ListAttribute<PersonEntity, MovieEntity> directedMovies;
	public static volatile SingularAttribute<PersonEntity, String> name;
	public static volatile SingularAttribute<PersonEntity, Long> id;
	public static volatile SingularAttribute<PersonEntity, String> biography;
	public static volatile SingularAttribute<PersonEntity, Date> birthDate;

	public static final String COUNTRY = "country";
	public static final String ROLE = "role";
	public static final String ACTED_IN_MOVIES = "actedInMovies";
	public static final String DIRECTED_MOVIES = "directedMovies";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String BIOGRAPHY = "biography";
	public static final String BIRTH_DATE = "birthDate";

}

