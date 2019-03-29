package bom.spring.study.controller;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.dto.ResponseGenreDto;
import bom.spring.study.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseGenreDto>> getGenres(){
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getGenres());
    }

    @PostMapping("/genre")
    public ResponseEntity addGenres(@RequestBody RequestGenreDto requestGenreDto){
        genreService.addGenre(requestGenreDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{genre-id}")
    public ResponseEntity deleteGenre(@PathVariable("genre-id") int genreId){
        genreService.deleteGenre(genreId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
