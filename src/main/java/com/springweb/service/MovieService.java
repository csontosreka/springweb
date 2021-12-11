package com.springweb.service;

import com.springweb.UITO.MovieUITO;

import java.util.List;

public interface MovieService {
    List<MovieUITO> fetchAllMovies();

    MovieUITO getMovie(MovieUITO movieUITO);

    MovieUITO saveMovie(MovieUITO movieUITO);

    void deleteMovie(MovieUITO movieUITO);
}
