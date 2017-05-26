package com.github.mszarlinski.webflux.web;

import com.github.mszarlinski.webflux.domain.Movie;
import com.github.mszarlinski.webflux.domain.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
class MovieController {

    private final MovieRepository movieRepository;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    Page<Movie> get1000Movies() {
        return movieRepository.findAll(PageRequest.of(1, 1000));
    }

    @PostMapping
    void saveMovies(List<String> names) {
        names.forEach(name -> movieRepository.save(new Movie(name)));
    }
}
