package com.github.mszarlinski.webflux.web;

import com.github.mszarlinski.webflux.adapter.mongo.ReactiveMongoMovieRepository;
import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.github.mszarlinski.webflux.util.Sleeper.sleep;

@RestController
@RequestMapping("/react/movies")
public class ReactiveMovieController {

    private final ReactiveMongoMovieRepository movieRepository;

    ReactiveMovieController(ReactiveMongoMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    Flux<Movie> getMovies() {
        sleep(Duration.ofSeconds(1));
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    Mono<Movie> getMovie(@PathVariable String movieId) {
        sleep(Duration.ofSeconds(1));
        return movieRepository.findById(movieId);
    }

    @PostMapping
    Mono<Movie> saveMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
