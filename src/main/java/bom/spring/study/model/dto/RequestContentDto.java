package bom.spring.study.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestContentDto {
    private int id;
    private String name;
    private String category;
    private int genreId;
}
