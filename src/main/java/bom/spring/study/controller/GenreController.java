package bom.spring.study.controller;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/genre")
    public ResponseEntity addGenres(@RequestBody RequestGenreDto requestGenreDto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/genres/{genre-id}")
    public ResponseEntity deleteGenre(@PathVariable("genre-id") int genreId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
