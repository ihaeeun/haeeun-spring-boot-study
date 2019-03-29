package bom.spring.study.service;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseAllContentsDto;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.List;

public interface ContentService {
    List<ResponseAllContentsDto> getAllContents();
    ResponseContentDto getContent(int contentId);
    List<ResponseAllContentsDto> getCategoryContent(String category);
    List<ResponseAllContentsDto> getGenreContent(int genreId);
    void addContent(RequestContentDto requestContentDto);
    void deleteContent(int contentId);
//    TODO : update
//    TODO : addContent할 때 genreId List로
}
