package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.vo.Content;

import java.util.List;

public interface ContentDao {
    List<Content> getAllContents();
    Content getContent(int contentId);
    int getContentId(String contentName, int year);
    List<Content> getContentsByCategory(String category);
    List<Content> getContentsByGenre(int genreId);
    int addContent(Content content);
    int deleteContent(int contentId);
}
