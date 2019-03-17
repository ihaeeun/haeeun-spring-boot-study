package bom.spring.study.service;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.vo.Content;
import bom.spring.study.repository.ContentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentService {
    private final ContentsRepository contentsRepository;

    public ContentService(ContentsRepository contentsRepository) {
        this.contentsRepository = contentsRepository;
    }

    public List<ResponseContentDto> getAllContents() {
        List<ResponseContentDto> responseContentDtos = new ArrayList<>();
        List<Content> contents = contentsRepository.getAllContents();

        for(Content content : contents) {
            ResponseContentDto responseContentDto = new ResponseContentDto(content.getId(), content.getName(), content.getCategory());
            responseContentDtos.add(responseContentDto);
        }
        return responseContentDtos;
    }

    public ResponseContentDto getContent(int contentId) {
        Content content = contentsRepository.getContent(contentId);
        ResponseContentDto responseContentDto = new ResponseContentDto(content.getId(), content.getName(), content.getCategory());
        return responseContentDto;
    }

    public List<ResponseContentDto> getCategoryContent(String category) {
        List<ResponseContentDto> responseContentDtos = new ArrayList<>();
        List<Content> contents = contentsRepository.getCategoryContents(category);

        for(Content content : contents) {
            ResponseContentDto responseContentDto = new ResponseContentDto(content.getId(), content.getName());
            responseContentDtos.add(responseContentDto);
        }

        return responseContentDtos;
    }

    public void addContent(RequestContentDto requestContentDto){
        contentsRepository.addContent(requestContentDto);
    }

    public void deleteContent(int contentId) {
        contentsRepository.deleteContent(contentId);
    }
}
