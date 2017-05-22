package com.github.mszarlinski.webflux.web;

import com.github.mszarlinski.webflux.adapter.mongo.FakeMovieRepository;
import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import static com.github.mszarlinski.webflux.util.Sleeper.sleep;

@RestController
@RequestMapping("/async/movies")
class AsyncMovieController {

    private final FakeMovieRepository movieRepository;

    private final ExecutorService executorService;

    AsyncMovieController(FakeMovieRepository movieRepository, final ExecutorService executorService) {
        this.movieRepository = movieRepository;
        this.executorService = executorService;
    }

    /**
     * Returning deferred result:
     * https://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-return-types
     */
    @GetMapping
    CompletableFuture<List<Movie>> getMovies() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofSeconds(1));
            return movieRepository.findAll();
        }, executorService);
    }

    @GetMapping("/{movieId}")
    CompletableFuture<Movie> getMovie(@PathVariable String movieId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(Duration.ofSeconds(1));
            return movieRepository.findById(movieId);
        }, executorService);
    }

    @ResponseBody
    @PostMapping
    Movie saveMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
