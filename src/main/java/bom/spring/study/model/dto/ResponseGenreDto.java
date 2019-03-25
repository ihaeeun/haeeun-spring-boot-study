package bom.spring.study.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGenreDto {
    private int genreId;
    private String genre;

//    public ResponseGenreDto(String genre) {
//        this.genre = genre;
//    }
}
