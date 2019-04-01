package bom.spring.study.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorModel {
    private int code;
    private String msg;
    private LocalDateTime timestamp;
}
