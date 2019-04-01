package bom.spring.study.mapper;

import bom.spring.study.model.vo.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre(rs.getInt("id"),
                rs.getString("genre"));
        return genre;
    }


}
