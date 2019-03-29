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
public class ResponseContentDto {
    private int id;
    private String name;
    private List<Genre> genres;
}