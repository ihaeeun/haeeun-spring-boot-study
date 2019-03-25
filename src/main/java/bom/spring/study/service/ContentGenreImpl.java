package bom.spring.study.service;

public class ContentGenreImpl implements ContentGenreService{
    private final ContentGenreService contentGenreService;

    public ContentGenreImpl(ContentGenreService contentGenreService) {
        this.contentGenreService = contentGenreService;
    }


}
