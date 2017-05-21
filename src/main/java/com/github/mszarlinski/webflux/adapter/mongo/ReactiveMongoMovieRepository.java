package com.github.mszarlinski.webflux.adapter.mongo;

import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveMongoMovieRepository extends ReactiveMongoRepository<Movie, String> {
}
