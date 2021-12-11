package com.springweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE")
@NamedQuery(name = "MovieDTO.findAll", query = "SELECT a FROM MovieDTO a")
public class MovieDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;
    @Column(name = "GENRE", nullable = false)
    private String genre;
    @Column(name = "MOVIE_LENGTH", nullable = false)
    private Integer length;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
