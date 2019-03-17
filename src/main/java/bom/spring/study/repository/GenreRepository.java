package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.vo.Genre;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {

    private final JdbcTemplate template;

    public GenreRepository(JdbcTemplate template) {
        this.template = template;
    }

    public List<Genre> getGenres() {
        List<Genre> genres = template.query("SELECT * FROM genre", (rs, rowNum) ->
                new Genre(rs.getInt("id"), rs.getString("genre")));
        return genres;
    }

    public int addGenre(RequestGenreDto requestGenreDto) {
        String insertQuery = "INSERT INTO genre VALUES (?, ?)";
        return template.update(insertQuery, new Object[]{requestGenreDto.getGenreId(), requestGenreDto.getGenre()}, new BeanPropertyRowMapper<>(Genre.class));
    }

    public int deleteGenre(int genreId) {
        String deleteQuery = "DELETE FROM genre WHERE id = ?";
        return template.update(deleteQuery, genreId);
    }
}
