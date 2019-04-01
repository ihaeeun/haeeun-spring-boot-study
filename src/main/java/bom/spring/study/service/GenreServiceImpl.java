package bom.spring.study.service;

import bom.spring.study.exception.NotFoundContent;
import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.GenreDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDaoImpl genreDaoImpl;

    public GenreServiceImpl(GenreDaoImpl genreDaoImpl) {
        this.genreDaoImpl = genreDaoImpl;
    }

    @Override
    public List<ResponseGenreDto> getGenres() {
        List<Genre> genres = Optional.ofNullable(genreDaoImpl.getGenres()).orElseThrow(NotFoundContent::new);
        return genres.stream().map(this::convert).collect(Collectors.toList());

    }

    @Override
    public List<ResponseGenreDto> getGenreName(int contentId) {
        List<Genre> genres = Optional
                .ofNullable(genreDaoImpl.getGenreName(contentId))
                .orElseThrow(NotFoundContent::new);

        return genres
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void addGenre(RequestGenreDto requestGenreDto){
        Genre genre = new Genre();
        genre.setGenre(requestGenreDto.getGenre());
        genreDaoImpl.addGenre(genre);
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
