package com.application.moviedatabase.entity;

import lombok.Data;

@Data
public class MovieFilter {

    private Long directorID = -1L;
    private Long actorID = -1L;
    private String genre = "";
    private Integer fromYear;
    private Integer toYear;
    private Integer limit = 10;

}
