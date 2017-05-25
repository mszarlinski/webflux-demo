package com.github.mszarlinski.webflux.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveMovieRepository extends ReactiveMongoRepository<Movie, String> {
}
