package bom.spring.study.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseContentDto {
    private int id;
    private String name;
    private String category;

    public ResponseContentDto(int id, String name){
        this.id = id;
        this.name = name;
    }
}
