package bom.spring.study.controller;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseAllContentsDto;
import bom.spring.study.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contents")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseAllContentsDto>> getAllContents(){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getAllContents());
    }

    @GetMapping("/{content-id}")
    public ResponseEntity<ResponseContentDto> getContent(@PathVariable("content-id") int contentId){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getContent(contentId));
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<ResponseAllContentsDto>> getCategoryContent(@PathVariable("category") String category){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getCategoryContent(category));
    }

    @GetMapping("/genres/{genre-id}")
    public ResponseEntity<List<ResponseAllContentsDto>> getGenreContent(@PathVariable("genre-id") int genreId){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getGenreContent(genreId));
    }

    @PostMapping(value = "/content")
    public ResponseEntity addContent(@RequestBody RequestContentDto requestContentDto){
        contentService.addContent(requestContentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{content-id}")
    public ResponseEntity deleteContent(@PathVariable("content-id") int contentId){
        contentService.deleteContent(contentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
