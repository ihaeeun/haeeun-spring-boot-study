package bom.spring.study.service;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.GenreDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDaoImpl genreDaoImpl;

    public GenreServiceImpl(GenreDaoImpl genreDaoImpl) {
        this.genreDaoImpl = genreDaoImpl;
    }

    @Override
    public List<ResponseGenreDto> getGenres() {
        List<Genre> genres = genreDaoImpl.getGenres();
        return genres.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public List<ResponseGenreDto> getGenreName(int contentId) {
        List<Genre> genres = genreDaoImpl.getGenreName(contentId);
        return genres.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public void addGenre(RequestGenreDto requestGenreDto){
        genreDaoImpl.addGenre(requestGenreDto);
    }

    @Override
    public void deleteGenre(int genreId){
        genreDaoImpl.deleteGenre(genreId);
    }


    private ResponseGenreDto convert(Genre genre) {
        ResponseGenreDto responseGenreDto = new ResponseGenreDto();
        responseGenreDto.setGenreId(genre.getGenreId());
        responseGenreDto.setGenre(genre.getGenre());
        return responseGenreDto;
    }

}
