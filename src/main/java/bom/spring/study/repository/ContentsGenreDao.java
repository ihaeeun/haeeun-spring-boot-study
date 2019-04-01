package bom.spring.study.repository;

import bom.spring.study.model.vo.Genre;

import java.util.List;

public interface ContentsGenreDao {
    void addContentGenre(int contentId, List<Integer> genreId);
    void deleteContentGenre(int contentId);
}
