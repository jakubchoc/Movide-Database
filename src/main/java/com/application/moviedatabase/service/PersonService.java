package com.application.moviedatabase.service;

import java.util.List;
import com.application.moviedatabase.constant.RoleType;
import com.application.moviedatabase.dto.PersonDTO;

public interface PersonService {

    PersonDTO addPerson(PersonDTO personDTO);

    List<PersonDTO> getPeople(RoleType role, int limit);

    PersonDTO getPerson(Long personId);

    PersonDTO editPerson(Long personId, PersonDTO personDTO);

    PersonDTO removePerson(Long personId);
}
