package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.vo.Content;

public interface ContentsGenreDao {
    int addContentGenre(Content contentId, int genreId);
    int deleteContentGenre(int contentId);
}
