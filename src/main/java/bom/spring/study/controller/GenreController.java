package bom.spring.study.controller;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.model.vo.Genre;
import bom.spring.study.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public ResponseEntity<List<ResponseGenreDto>> getGenres(){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getGenres());
    }

    @PostMapping(value = "/genre")
    public ResponseEntity addGenres(@RequestBody RequestGenreDto requestGenreDto){
        genreService.addGenre(requestGenreDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/genres/{genre-id}")
    public ResponseEntity deleteGenre(@PathVariable("genre-id") int genreId){
        genreService.deleteGenre(genreId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
