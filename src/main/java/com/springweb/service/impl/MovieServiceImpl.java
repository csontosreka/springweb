package com.springweb.service.impl;

import com.springweb.UITO.MovieUITO;
import com.springweb.entity.MovieDTO;
import com.springweb.repository.MovieRepository;
import com.springweb.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieUITO> fetchAllMovies() {
        List<MovieUITO> movieUITOList = new ArrayList<>();
        List<MovieDTO> movieDTOList = movieRepository.findAll();

        movieDTOList.forEach(dto -> {
            MovieUITO tempUITO = new MovieUITO();

            BeanUtils.copyProperties(dto, tempUITO);
            movieUITOList.add(tempUITO);
        });

        return movieUITOList;
    }

    @Override
    public MovieUITO getMovie(MovieUITO movieUITO) {
        MovieDTO dto = movieRepository.findMoviesDTOByTitle(movieUITO.getTitle());
        MovieUITO uito = new MovieUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }

    @Override
    @Transactional(readOnly = false)
    public MovieUITO saveMovie(MovieUITO movieUITO) {
        MovieDTO dto = UITOToDTO(movieUITO);
        dto = movieRepository.save(dto);
        BeanUtils.copyProperties(dto, movieUITO);
        return movieUITO;
    }

    @Override
    @Transactional
    public void deleteMovie(MovieUITO movieUITO) {
        movieRepository.deleteById(movieUITO.getId());
    }


    private MovieDTO UITOToDTO(MovieUITO movieUITO) {
        MovieDTO dto = new MovieDTO();
        BeanUtils.copyProperties(movieUITO, dto);
        List<MovieDTO> list = new ArrayList<>();
        list.add(dto);
        return dto;
    }


}
