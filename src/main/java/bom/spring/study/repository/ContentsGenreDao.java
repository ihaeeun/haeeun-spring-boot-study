package bom.spring.study.repository;

public interface ContentsGenreDao {
    void addContentGenre(int contentId, int genreId);
    void deleteContentGenre(int contentId);
}
