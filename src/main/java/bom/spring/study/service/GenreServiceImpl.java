package bom.spring.study.service;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseContentListDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.model.vo.Content;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.GenreDaoImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDaoImpl genreDaoImpl;

    public GenreServiceImpl(GenreDaoImpl genreDaoImpl) {
        this.genreDaoImpl = genreDaoImpl;
    }

    private List<ResponseGenreDto> convert(List<Genre> genres) {
        List<ResponseGenreDto> responseGenreDtos = new ArrayList<>();

        for(Genre genre : genres) {
            ResponseGenreDto responseGenreDto = new ResponseGenreDto(genre.getGenreId(), genre.getGenre());
            responseGenreDtos.add(responseGenreDto);
        }

        return responseGenreDtos;
    }

    @Override
    public List<ResponseGenreDto> getGenres() {
        List<ResponseGenreDto> responseGenreDtos;
        List<Genre> genres = genreDaoImpl.getGenres();

        responseGenreDtos = convert(genres);

        return responseGenreDtos;
    }

    @Override
    public List<ResponseGenreDto> getGenreName(int contentId) {
        List<ResponseGenreDto> responseGenreDtos;
        List<Genre> genres = genreDaoImpl.getGenreName(contentId);

        responseGenreDtos = convert(genres);

        return responseGenreDtos;
    }

    @Override
    public void addGenre(RequestGenreDto requestGenreDto){
        genreDaoImpl.addGenre(requestGenreDto);
    }

    @Override
    public void deleteGenre(int genreId){
        genreDaoImpl.deleteGenre(genreId);
    }
}
