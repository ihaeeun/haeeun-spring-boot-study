package bom.spring.study.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentsGenreDaoImpl implements ContentsGenreDao {
    public final JdbcTemplate jdbcTemplate;

    public ContentsGenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addContentGenre(int contentId, int genreId) {
        String insertQuery = "INSERT INTO content_genre VALUES (?, ?)";
        jdbcTemplate.update(insertQuery, contentId, genreId);
    }

    @Override
    public void deleteContentGenre(int contentId) {
        String deleteQuery = "DELETE FROM content_genre WHERE contents_id = ?";
        jdbcTemplate.update(deleteQuery, contentId);
    }
}
