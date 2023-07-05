package com.application.moviedatabase.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("com.application.movie-database")
public class GenreConfiguration {

    private List<String> genres;
}
