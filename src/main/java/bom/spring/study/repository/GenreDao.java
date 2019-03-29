package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.vo.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getGenres();
    List<Genre> getGenreName(int genreId);
    void addGenre(RequestGenreDto requestGenreDto);
    void deleteGenre(int genreId);
}
