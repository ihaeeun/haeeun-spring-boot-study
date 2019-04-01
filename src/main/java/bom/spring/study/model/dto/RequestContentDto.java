package bom.spring.study.model.dto;

import bom.spring.study.model.vo.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestContentDto {
    private String name;
    private String category;
    private int year;
    private List<Integer> genreId;
}
