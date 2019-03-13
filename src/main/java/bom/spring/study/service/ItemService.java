package bom.spring.study.service;

import bom.spring.study.model.dto.ResponseItemDto;
import bom.spring.study.model.vo.Item;
import bom.spring.study.model.dto.RequestItemDto;
import bom.spring.study.repository.ItemRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ResponseItemDto> getAllItems() {
        List<ResponseItemDto> responseItemDtos = new ArrayList<>();
        List<Item> items = itemRepository.getAllItems();
        for (Item item : items) {
            ResponseItemDto responseItemDto = new ResponseItemDto(item.getId(), item.getName(), item.getCategory());
            responseItemDtos.add(responseItemDto);
        }
        return responseItemDtos;
    }

    public ResponseItemDto getItem(int itemId) {
        Item item = itemRepository.getItem(itemId);
        ResponseItemDto responseItemDto = new ResponseItemDto(item.getId(), item.getName(), item.getCategory());
        return responseItemDto;
    }

    public void addItem(RequestItemDto requestItemDto) {
        itemRepository.addItem(requestItemDto);
    }

    public void deleteItem(int itemId) {
        itemRepository.deleteItem(itemId);
    }
}