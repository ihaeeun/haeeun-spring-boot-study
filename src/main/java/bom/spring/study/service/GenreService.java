package bom.spring.study.service;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseGenreDto;

import java.util.List;

public interface GenreService {
    List<ResponseGenreDto> getGenres();
    List<ResponseGenreDto> getGenreName(int contentId);
    void addGenre(RequestGenreDto requestGenreDto);
    void deleteGenre(int genreId);
}
