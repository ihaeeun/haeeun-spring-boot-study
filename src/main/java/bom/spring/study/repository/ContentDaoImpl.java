package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;
import bom.spring.study.model.vo.Content;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentDaoImpl implements ContentDao {

    private final JdbcTemplate jdbcTemplate;

    public ContentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Content> getAllContents(){
        List<Content> contents = jdbcTemplate.query("SELECT * FROM contents", (rs, rowNum) ->
            new Content(rs.getInt("id"), rs.getString("name"), rs.getString("category")));
        return contents;
    }

    @Override
    public Content getContent(int contentId){
        String selectQuery = "SELECT id, name FROM contents WHERE id = ?";
        Content content = jdbcTemplate.queryForObject(selectQuery, new Object[]{contentId}, new BeanPropertyRowMapper<>(Content.class));
        return content;
    }

//    @Override
//    public Content getContentId(String contentName) {
//        String selectQuery = "SELECT id FROM contents WHERE name = ?";
//        Content content = jdbcTemplate.queryForObject(selectQuery, new Object[]{contentName}, (rs, rowNum) ->
//                new Content(rs.getInt("id")));
//        return content;
//    }

    @Override
    public int getContentId(String contentName) {
        String selectQuery = "SELECT id FROM contents WHERE name = ?";
        Content content = jdbcTemplate.queryForObject(selectQuery, new Object[]{contentName}, (rs, rowNum) ->
                new Content(rs.getInt("id")));
        return content.getId();
    }

    @Override
    public List<Content> getCategoryContents(String category){
        String selectQuery = "SELECT id, name FROM contents WHERE category = ?";
        List<Content> contents = jdbcTemplate.query(selectQuery, new Object[]{category}, (rs, rowNum) ->
                new Content(rs.getInt("id"), rs.getString("name")));
        return contents;
    }

    @Override
    public List<Content> getGenreContents(int genreId){
        String selectQuery = "SELECT * FROM contents AS c JOIN contents_genre AS cg ON cd.id = ?";
        List<Content> contents = jdbcTemplate.query(selectQuery, new Object[]{genreId}, (rs, rowNum) ->
                new Content(rs.getInt("id"), rs.getString("name")));
        return contents;
    }

    @Override
    public void addContent(RequestContentDto requestContentDto){
        String insertQuery = "INSERT INTO contents (name, category) VALUES (?, ?)";
        jdbcTemplate.update(insertQuery, requestContentDto.getName(), requestContentDto.getCategory());
    }

    @Override
    public void deleteContent(int contentId){
        String deleteQuery = "DELETE FROM contents WEHRE id = ?";
        jdbcTemplate.update(deleteQuery, contentId);
    }
}
