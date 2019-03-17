package bom.spring.study.controller;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.dto.ResponseContentDto;
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
    public ResponseEntity<List<ResponseContentDto>> getAllContents(){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getAllContents());
    }

    @GetMapping("/content/{contentId}")
    public ResponseEntity<ResponseContentDto> getContent(@PathVariable("contentId") int contentId){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getContent(contentId));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ResponseContentDto>> getCategoryContent(@PathVariable("category") String category){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getCategoryContent(category));
    }

    @PostMapping("/content")
    public ResponseEntity addContent(@RequestBody RequestContentDto requestContentDto){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/content/{contentId}")
    public ResponseEntity deleteContent(@PathVariable("contentId") int contentId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
