package com.github.mszarlinski.webflux.web;

import com.github.mszarlinski.webflux.domain.Movie;
import com.github.mszarlinski.webflux.domain.ReactiveMovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
class MovieController {

    private final ReactiveMovieRepository movieRepository;

    MovieController(ReactiveMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    Flux<Movie> get1000Movies() {
        return movieRepository.findAll()
                .take(1000);
    }

    @PostMapping
    Mono<Void> saveMovies(Flux<String> names) {
        return names.map(Movie::new)
                .map(movieRepository::save)
                .then();
    }
}
