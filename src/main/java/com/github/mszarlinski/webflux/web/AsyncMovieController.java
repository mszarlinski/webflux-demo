package com.github.mszarlinski.webflux.web;

import com.github.mszarlinski.webflux.adapter.mongo.FakeMovieRepository;
import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.github.mszarlinski.webflux.util.Sleeper.sleep;

@RestController
@RequestMapping("/async/movies")
class AsyncMovieController {

    private final FakeMovieRepository movieRepository;

    AsyncMovieController(FakeMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    CompletableFuture<List<Movie>> getMovies() { // or DeferredResult - what is the difference?
        return CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofSeconds(1));
            return movieRepository.findAll();
        });
    }

    @GetMapping("/{movieId}")
    CompletableFuture<Movie> getMovie(@PathVariable String movieId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofSeconds(1));
            return movieRepository.findById(movieId);
        });
    }

    @PostMapping
    Movie saveMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
