package com.application.moviedatabase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieDTO {

    @NonNull
    @JsonProperty("_id")
    private long id;
    @NotBlank
    private String name;
    @NotNull
    private Long directorID;
    private List<@Positive Long> actorIDs;
    private boolean isAvailable;
    @NotNull
    private List<String> genres;
    @NotNull
    @Positive
    private Integer year;
    private LocalDate dateAdded;
    private PersonDTO director;
    private List<PersonDTO> actors;
}
