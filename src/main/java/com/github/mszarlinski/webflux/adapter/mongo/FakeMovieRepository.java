package com.github.mszarlinski.webflux.adapter.mongo;

import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class FakeMovieRepository {

    public Movie findById(final String id) {
        return new Movie();
    }

    public Movie save(final Movie movie) {
        return new Movie();
    }

    public List<Movie> findAll() {
        return asList(new Movie());
    }
}
