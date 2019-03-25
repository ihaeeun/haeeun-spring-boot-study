package bom.spring.study.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    private int genreId;
    private String genre;

    public Genre(String genre){
        this.genre = genre;
    }
}
