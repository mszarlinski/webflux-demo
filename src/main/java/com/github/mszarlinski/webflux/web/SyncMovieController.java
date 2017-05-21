package com.github.mszarlinski.webflux.web;

import com.github.mszarlinski.webflux.adapter.mongo.FakeMovieRepository;
import com.github.mszarlinski.webflux.domain.Movie;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

import static com.github.mszarlinski.webflux.util.Sleeper.sleep;

@RestController
@RequestMapping("/sync/movies")
class SyncMovieController {

    private final FakeMovieRepository movieRepository;

    SyncMovieController(FakeMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    List<Movie> getMovies() {
        sleep(Duration.ofSeconds(1));
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    Movie getMovie(@PathVariable String movieId) {
        sleep(Duration.ofSeconds(1));
        return movieRepository.findById(movieId);
    }

    @PostMapping
    Movie saveMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

}
