package bom.spring.study.repository;

import bom.spring.study.model.vo.Item;
import bom.spring.study.model.dto.RequestItemDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    private final JdbcTemplate template;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public List<Item> getAllItems(){
        List<Item> items = template.query("SELECT id, name, category FROM item", (result, rowNum) ->
                new Item(result.getInt("id"), result.getString("name"), result.getString("category")));
        return items;
    }

    public Item getItem(int itemId){
        String selectQuery = "SELECT * FROM item WHERE id=?";
        Item item = template.queryForObject(selectQuery, new Object[]{itemId}, new BeanPropertyRowMapper<>(Item.class));
        return item;
    }

    public int addItem(RequestItemDto requestItemDto){
        String insertQuery = "INSERT INTO item VALUES (?, ?, ?)";
        return template.update(insertQuery, requestItemDto.getId(), requestItemDto.getName(), requestItemDto.getCategory());
    }

    public int deleteItem(int id){
        String deleteQuery = "DELETE FROM item WHERE id = ?";
        return template.update(deleteQuery, id);
    }
}
