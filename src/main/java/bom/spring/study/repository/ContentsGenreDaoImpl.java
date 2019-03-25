package bom.spring.study.repository;

import bom.spring.study.model.dto.RequestContentDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentsGenreDaoImpl implements ContentsGenreDao {
    public final JdbcTemplate template;

    public ContentsGenreDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addContentGenre(RequestContentDto requestContentDto) {
        String insertQuery = "INSERT INTO content_genre VALUES (?, ?)";
        return template.update(insertQuery, requestContentDto.getId(), requestContentDto.getGenreId());
    }

    @Override
    public int deleteContentGenre(int contentId) {
        String deleteQuery = "DELETE FROM content_genre WHERE contents_id = ?";
        return template.update(deleteQuery, contentId);
    }
}
