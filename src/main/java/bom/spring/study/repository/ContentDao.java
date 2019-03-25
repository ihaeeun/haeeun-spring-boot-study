package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.vo.Content;

import java.util.List;

public interface ContentDao {
    List<Content> getAllContents();
    Content getContent(int contentId);
    Content getContentId(String contentName);
    List<Content> getCategoryContents(String category);
    List<Content> getGenreContents(int genreId);
    int addContent(RequestContentDto requestContentDto);
    int deleteContent(int contentId);
}
