package bom.spring.study.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private int id;
    private String name;
    private String category;

    public Content(int id, String name) {
    }
}
