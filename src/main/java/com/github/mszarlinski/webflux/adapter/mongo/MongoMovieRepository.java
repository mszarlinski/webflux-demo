package com.github.mszarlinski.webflux.adapter.mongo;

import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoMovieRepository extends MongoRepository<Movie, String> {

}
