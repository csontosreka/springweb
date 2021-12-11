package com.springweb.repository;

import com.springweb.entity.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieDTO, Long> {
    MovieDTO findMoviesDTOByTitle(String title);
}
