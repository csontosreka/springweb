package com.springweb.UITO;

import java.util.Objects;

public class MovieUITO {

    private Long id;
    private String title;
    private String genre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieUITO that = (MovieUITO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title)
                && Objects.equals(genre, that.genre) && Objects.equals(length, that.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, length);
    }
}
