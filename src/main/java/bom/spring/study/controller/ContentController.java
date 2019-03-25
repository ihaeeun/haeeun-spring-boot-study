package bom.spring.study.controller;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
import bom.spring.study.model.dto.ResponseContentListDto;
import bom.spring.study.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/contents")
    public ResponseEntity<List<ResponseContentListDto>> getAllContents(){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getAllContents());
    }

    @GetMapping("/contents/{content-id}")
    public ResponseEntity<ResponseContentDto> getContent(@PathVariable("content-id") int contentId){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getContent(contentId));
    }

    @GetMapping("/contents/categories/{category}")
    public ResponseEntity<List<ResponseContentListDto>> getCategoryContent(@PathVariable("category") String category){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getCategoryContent(category));
    }

    @GetMapping("/contents/genres/{genre-id}")
    public ResponseEntity<List<ResponseContentListDto>> getGenreContent(@PathVariable("genre-id") int genreId){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getGenreContent(genreId));
    }

    @PostMapping("/content")
    public ResponseEntity addContent(@RequestBody RequestContentDto requestContentDto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/contents/{content-id}")
    public ResponseEntity deleteContent(@PathVariable("content-id") int contentId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
