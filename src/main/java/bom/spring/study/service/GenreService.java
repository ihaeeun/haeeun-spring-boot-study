package bom.spring.study.service;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<ResponseGenreDto> getGenres() {
        List<ResponseGenreDto> responseGenreDtos = new ArrayList<>();
        List<Genre> genres = genreRepository.getGenres();

        for(Genre genre : genres) {
            ResponseGenreDto responseGenreDto = new ResponseGenreDto(genre.getGenreId(), genre.getGenre());
            responseGenreDtos.add(responseGenreDto);
        }

        return responseGenreDtos;
    }

    public void addGenre(RequestGenreDto requestGenreDto){
        genreRepository.addGenre(requestGenreDto);
    }

    public void deleteGenre(int genreId){
        genreRepository.deleteGenre(genreId);
    }
}
