package bom.spring.study.controller;

import bom.spring.study.model.dto.ResponseItemDto;
import bom.spring.study.model.vo.Item;
import bom.spring.study.model.dto.RequestItemDto;
import bom.spring.study.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<ResponseItemDto>> getAllItems(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItems());
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ResponseItemDto> getItem(@PathVariable("itemId") int itemId){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItem(itemId));
    }

    @PostMapping("/item")
    public ResponseEntity addItem(@RequestBody RequestItemDto requestItemDto){
        itemService.addItem(requestItemDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity deleteItem(@PathVariable("itemId") int itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
