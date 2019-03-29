package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.vo.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public GenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = jdbcTemplate.query("SELECT * FROM genre", (rs, rowNum) ->
                new Genre(rs.getInt("id"), rs.getString("genre")));
        return genres;
    }

    @Override
    public List<Genre> getGenreName(int contentId) {
        String selectQuery = "SELECT cg.genreId, g.genre FROM contents_genre AS cg JOIN genre AS g ON cg.genreId = g.id WHERE cg.contentId = ?";
        List<Genre> genreNames = jdbcTemplate.query(selectQuery, new Object[]{contentId}, (rs, rowNum) ->
                new Genre(rs.getString("genre")));
        return genreNames;
    }

    @Override
    public void addGenre(RequestGenreDto requestGenreDto) {
        String insertQuery = "INSERT INTO genre (genre) VALUES (?)";
        jdbcTemplate.update(insertQuery, requestGenreDto.getGenre());
    }

    @Override
    public void deleteGenre(int genreId) {
        String deleteQuery = "DELETE FROM genre WHERE id = ?";
        jdbcTemplate.update(deleteQuery, genreId);
    }
}