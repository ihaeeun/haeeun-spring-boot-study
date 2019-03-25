package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;

public interface ContentsGenreDao {
    int addContentGenre(RequestContentDto requestContentDto);
    int deleteContentGenre(int contentId);
}
