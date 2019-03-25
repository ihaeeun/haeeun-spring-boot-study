package bom.spring.study.service;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseContentListDto;

import java.util.List;

public interface ContentService {
    List<ResponseContentListDto> getAllContents();
    ResponseContentDto getContent(int contentId);
    List<ResponseContentListDto> getCategoryContent(String category);
    List<ResponseContentListDto> getGenreContent(int genreId);
    void addContent(RequestContentDto requestContentDto);
    void deleteContent(int contentId);
}
