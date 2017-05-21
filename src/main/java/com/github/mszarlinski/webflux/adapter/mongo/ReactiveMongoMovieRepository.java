package com.github.mszarlinski.webflux.adapter.mongo;

import com.github.mszarlinski.webflux.Profiles;
import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

@Profile(Profiles.REACTIVE_MONGO)
public interface ReactiveMongoMovieRepository extends ReactiveMongoRepository<Movie, String> {
}
