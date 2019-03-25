package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestGenreDto;
import bom.spring.study.model.vo.Genre;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {

    private final JdbcTemplate template;

    public GenreDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = template.query("SELECT * FROM genre", (rs, rowNum) ->
                new Genre(rs.getInt("id"), rs.getString("genre")));
        return genres;
    }

    @Override
    public List<Genre> getGenreName(int contentId) {
        String selectQuery = "SELECT cg.genreId, g.genre FROM contents_genre AS cg JOIN genre AS g ON cg.genreId = g.id WHERE cg.contentId = ?";
        List<Genre> genreName = template.query(selectQuery, new Object[]{contentId}, (rs, rowNum) ->
                new Genre(rs.getString("genre")));
        return genreName;
    }

    @Override
    public int addGenre(RequestGenreDto requestGenreDto) {
        String insertQuery = "INSERT INTO genre VALUES (?, ?)";
        return template.update(insertQuery, new Object[]{requestGenreDto.getGenreId(), requestGenreDto.getGenre()}, new BeanPropertyRowMapper<>(Genre.class));
    }

    @Override
    public int deleteGenre(int genreId) {
        String deleteQuery = "DELETE FROM genre WHERE id = ?";
        return template.update(deleteQuery, genreId);
    }
}