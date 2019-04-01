package bom.spring.study.service;

import bom.spring.study.exception.BadRequest;
import bom.spring.study.exception.NotFoundContent;
import bom.spring.study.exception.NotFoundGenre;
import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseAllContentsDto;
import bom.spring.study.model.vo.Content;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.ContentDao;
import bom.spring.study.repository.ContentsGenreDao;
import bom.spring.study.repository.GenreDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    public List<ResponseAllContentsDto> getAllContents() {
        List<Content> contents = Optional
                .ofNullable(contentDao.getAllContents())
                .orElseThrow(NotFoundContent::new);
        
        return contents
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseContentDto getContent(int contentId) {
        Content content = Optional
                .ofNullable(contentDao.getContent(contentId))
                .orElseThrow(() -> new NotFoundContent());

        List<Genre> genres = Optional
                .ofNullable(genreDao.getGenreName(contentId))
                .orElseThrow(NotFoundGenre::new);

        return new ResponseContentDto(content.getId(), content.getName(), genres);
    }

    @Override
    public List<ResponseAllContentsDto> getContentsByCategory(String category) {
        List<Content> contents = Optional
                .ofNullable(contentDao.getContentsByCategory(category))
                .orElseThrow(NotFoundContent::new);
        System.out.println(contents);
        return contents
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseAllContentsDto> getContentsByGenre(int genreId) {
        List<Content> contents = contentDao.getContentsByGenre(genreId);
        return contents
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

//  @TODO 중복 데이터 들어갈 경우 처리
//  @TODO Transaction 걸릴때 auto increment
//  @TODO add 하고, 겹치는게 2개여서 에러발생
    @Override
    @Transactional
    public void addContent(RequestContentDto requestContentDto){
        Content content = new Content();
        content.setName(requestContentDto.getName());
        content.setCategory(requestContentDto.getCategory());
        content.setYear(requestContentDto.getYear());
        contentDao.addContent(content);

        int contentId = contentDao.getContentId(requestContentDto.getName(), requestContentDto.getYear());
        contentsGenreDao.addContentGenre(contentId, requestContentDto.getGenreId());
    }

    @Override
    @Transactional
    public void deleteContent(int contentId) {
        Optional.ofNullable(contentDao.getContent(contentId)).orElseThrow(BadRequest::new);
        contentDao.deleteContent(contentId);
        contentsGenreDao.deleteContentGenre(contentId);
    }

    private ResponseAllContentsDto convert(Content content) {
        ResponseAllContentsDto responseAllContentsDto = new ResponseAllContentsDto();
        responseAllContentsDto.setId(content.getId());
        responseAllContentsDto.setName(content.getName());

        return responseAllContentsDto;
    }
}
