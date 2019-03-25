package bom.spring.study.service;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseContentListDto;
import bom.spring.study.model.vo.Content;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.ContentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{
    private final ContentDao contentDao;
    private final GenreService genreService;

    public ContentServiceImpl(ContentDao contentDao, GenreService genreService) {
        this.contentDao = contentDao;
        this.genreService = genreService;
    }

    private List<ResponseContentListDto> convert(List<Content> contents) {
        List<ResponseContentListDto> responseContentListDtos = new ArrayList<>();

        for(Content content : contents) {
            ResponseContentListDto responseContentListDto = new ResponseContentListDto(content.getId(), content.getName());
            responseContentListDtos.add(responseContentListDto);
        }
        return responseContentListDtos;
    }

    @Override
    public List<ResponseContentListDto> getAllContents() {
        List<ResponseContentListDto> responseContentListDtos;
        List<Content> contents = contentDao.getAllContents();

        responseContentListDtos = convert(contents);

        return responseContentListDtos;
    }

//    TODO exception (genre가 없을 때 null 반환 => nullPointException)
    @Override
    public ResponseContentDto getContent(int contentId) {
        Content content = contentDao.getContent(contentId);
        Genre genre = (Genre) genreService.getGenreName(contentId);
        ResponseContentDto responseContentDto = new ResponseContentDto(content.getId(), content.getName(), genre.getGenre());

        return responseContentDto;
    }

    @Override
    public List<ResponseContentListDto> getCategoryContent(String category) {
        List<ResponseContentListDto> responseContentListDtos;
        List<Content> contents = contentDao.getCategoryContents(category);

        responseContentListDtos = convert(contents);

        return responseContentListDtos;
    }

    @Override
    public List<ResponseContentListDto> getGenreContent(int genreId) {
        List<ResponseContentListDto> responseContentListDtos;
        List<Content> contents = contentDao.getGenreContents(genreId);

        responseContentListDtos = convert(contents);

        return responseContentListDtos;
    }

//    TODO Transactional
    @Override
    @Transactional
    public void addContent(RequestContentDto requestContentDto){
        contentDao.addContent(requestContentDto);

    }

    @Override
    @Transactional
    public void deleteContent(int contentId) {
        contentDao.deleteContent(contentId);
    }
}
