package bom.spring.study.mapper;

import bom.spring.study.model.vo.Content;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentMapper implements RowMapper<Content> {
    public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        Content content = new Content(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getInt("year"));

        return content;
    }
}
