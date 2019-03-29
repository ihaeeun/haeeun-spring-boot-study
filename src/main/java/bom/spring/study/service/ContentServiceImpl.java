package bom.spring.study.service;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseContentListDto;
import bom.spring.study.model.vo.Content;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.ContentDao;
import bom.spring.study.repository.ContentsGenreDao;
import bom.spring.study.repository.GenreDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService{
    private final ContentDao contentDao;
    private final GenreDao genreDao;
    private final ContentsGenreDao contentsGenreDao;

    public ContentServiceImpl(ContentDao contentDao, GenreDao genreDao, ContentsGenreDao contentsGenreDao) {
        this.contentDao = contentDao;
        this.genreDao = genreDao;
        this.contentsGenreDao = contentsGenreDao;
    }

    @Override
    public List<ResponseContentListDto> getAllContents() {
        List<Content> contents = contentDao.getAllContents();
        return contents.stream().map(this::convert).collect(Collectors.toList());
    }

//    TODO exception (genre가 없을 때 null 반환 => nullPointException)
    @Override
    public ResponseContentDto getContent(int contentId) {
        Content content = contentDao.getContent(contentId);
        List<Genre> genres = genreDao.getGenreName(contentId);
        ResponseContentDto responseContentDto = new ResponseContentDto(content.getId(), content.getName(), genres);

        return responseContentDto;
    }

    @Override
    public List<ResponseContentListDto> getCategoryContent(String category) {
        List<Content> contents = contentDao.getCategoryContents(category);
        return contents.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public List<ResponseContentListDto> getGenreContent(int genreId) {
        List<Content> contents = contentDao.getGenreContents(genreId);
        return contents.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addContent(RequestContentDto requestContentDto){
        contentDao.addContent(requestContentDto);
        Content contentId = contentDao.getContentId(requestContentDto.getName());
        contentsGenreDao.addContentGenre(contentId, requestContentDto.getGenreId());
    }

    @Override
    @Transactional
    public void deleteContent(int contentId) {
        contentDao.deleteContent(contentId);
        contentsGenreDao.deleteContentGenre(contentId);
    }

    private ResponseContentListDto convert(Content content) {
        ResponseContentListDto responseContentListDto = new ResponseContentListDto();
        responseContentListDto.setId(content.getId());
        responseContentListDto.setName(content.getName());
        return responseContentListDto;
    }
}
