package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.vo.Content;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentsRepository {

    private final JdbcTemplate template;

    public ContentsRepository(JdbcTemplate jdbcTemplate) { this.template = jdbcTemplate; }

    public List<Content> getAllContents(){
        List<Content> contents = template.query("SELECT * FROM contents", (rs, rowNum) ->
            new Content(rs.getInt("id"), rs.getString("name"), rs.getString("category")));
        return contents;
    }

    public Content getContent(int contentId){
        String selectQuery = "SELECT * FROM contents WHERE id = ?";
        Content content = template.queryForObject(selectQuery, new Object[]{contentId}, new BeanPropertyRowMapper<>(Content.class));
        return content;
    }

    public int insertContent(RequestContentDto requestContentDto){
        String insertQuery = "INSERT INTO contents VALUES (?, ?, ?)";
        return template.update(insertQuery, requestContentDto.getId(), requestContentDto.getName(), requestContentDto.getCategory());
    }

    public int deleteContent(int contentId){
        String deleteQuery = "DELETE FROM contents WEHRE id = ?";
        return template.update(deleteQuery, contentId);
    }
}
