package bom.spring.study.repository;

import bom.spring.study.mapper.GenreMapper;
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
        return jdbcTemplate.query("SELECT * FROM genre", new GenreMapper());
    }

    @Override
    public List<Genre> getGenreName(int contentId) {
        String selectQuery = "SELECT g.id, g.genre FROM contents_genre AS cg JOIN genre AS g ON cg.genre_id = g.id WHERE cg.contents_id = ?";
        List<Genre> genres = jdbcTemplate.query(selectQuery, new Object[]{contentId}, new GenreMapper());
        return genres;
    }

    @Override
    public void addGenre(Genre genre) {
        String insertQuery = "INSERT INTO genre (genre) VALUES (?)";
        jdbcTemplate.update(insertQuery, genre.getGenre());
    }

    @Override
    public void deleteGenre(int genreId) {
        String deleteQuery = "DELETE FROM genre WHERE id = ?";
        jdbcTemplate.update(deleteQuery, genreId);
    }
}