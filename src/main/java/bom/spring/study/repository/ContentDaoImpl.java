package bom.spring.study.repository;

import bom.spring.study.mapper.ContentMapper;
import bom.spring.study.model.vo.Content;
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
        return jdbcTemplate.query("SELECT * FROM contents", new ContentMapper());
    }

    @Override
    public Content getContent(int contentId){
        String selectQuery = "SELECT * FROM contents WHERE id = ?";
        return jdbcTemplate.queryForObject(selectQuery, new Object[]{contentId}, new ContentMapper());
    }

    @Override
    public int getContentId(String contentName, int year) {
        String selectQuery = "SELECT * FROM contents WHERE name = ? AND year = ?";
        Content content = jdbcTemplate.queryForObject(selectQuery, new Object[]{contentName, year}, new ContentMapper());
        return content.getId();
    }

    @Override
    public List<Content> getContentsByCategory(String category){
        String selectQuery = "SELECT * FROM contents WHERE category = ?";
        return jdbcTemplate.query(selectQuery, new Object[]{category}, new ContentMapper());
    }

    @Override
    public List<Content> getContentsByGenre(int genreId){
        String selectQuery = "SELECT * FROM contents AS c JOIN contents_genre AS cg ON c.id = cg.contents_id WHERE cg.genre_id= ?";
        return jdbcTemplate.query(selectQuery, new Object[]{genreId}, new ContentMapper());
    }

    @Override
    public int addContent(Content content){
        String insertQuery = "INSERT INTO contents (name, category, year) VALUES (?, ?, ?)";
        return jdbcTemplate.update(insertQuery, content.getName(), content.getCategory(), content.getYear());
    }

    @Override
    public int deleteContent(int contentId){
        String deleteQuery = "DELETE FROM contents WEHRE id = ?";
        return jdbcTemplate.update(deleteQuery, contentId);
    }
}
