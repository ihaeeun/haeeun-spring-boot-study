package bom.spring.study.repository;

import bom.spring.study.model.vo.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getGenres();
    List<Genre> getGenreName(int genreId);
    void addGenre(Genre genre);
    void deleteGenre(int genreId);
}
