package bom.spring.study.repository;

import bom.spring.study.model.vo.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentsGenreDaoImpl implements ContentsGenreDao {
    public final JdbcTemplate jdbcTemplate;

    public ContentsGenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addContentGenre(int contentId, List<Integer> genreId) {
        String insertQuery = "INSERT INTO contents_genre VALUES (?, ?)";
        for (Integer id :genreId) {
            jdbcTemplate.update(insertQuery, contentId, id);
        }
    }

    @Override
    public void deleteContentGenre(int contentId) {
        String deleteQuery = "DELETE FROM contents_genre WHERE contents_id = ?";
        jdbcTemplate.update(deleteQuery, contentId);
    }
}
