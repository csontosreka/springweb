package com.springweb.controller;

import com.springweb.UITO.MovieUITO;
import com.springweb.service.MovieService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("movieController")
@SessionScope
public class MovieController {
    @Autowired
    private MovieService movieService;

    private String actionLabel;
    private MovieUITO movieUITO;
    private List<MovieUITO> movieUITOList;

    public void saveMovie() {
        movieService.saveMovie(this.movieUITO);
        getAllMovies();
        this.setMovieUITO(new MovieUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Movie Details", "Movie Details added/Updated Successfully."));
    }

    public void deleteMovie(MovieUITO movieUITO) {
        movieService.deleteMovie(movieUITO);
        getAllMovies();
    }

    public void editMovie(MovieUITO movieUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(movieUITO, this.movieUITO);
    }

    @PostConstruct
    public void getAllMovies() {
        if (!this.getMovieUITOList().isEmpty()) {
            this.getMovieUITOList().clear();
        }
        this.getMovieUITOList().addAll(movieService.fetchAllMovies());
        this.setActionLabel("Add");
    }

    public MovieUITO getMovieUITO() {
        if (movieUITO == null) {
            movieUITO = new MovieUITO();
        }
        return movieUITO;
    }

    public void setMovieUITO(MovieUITO movieUITO) {
        this.movieUITO = movieUITO;
    }

    public List<MovieUITO> getMovieUITOList() {
        if (null == movieUITOList) {
            movieUITOList = new ArrayList<>();
        }
        return movieUITOList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }
}
