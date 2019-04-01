package bom.spring.study.exception;

import java.time.LocalDateTime;

public class NotFoundGenre extends BaseException{
    public NotFoundGenre() {
        this ("Not Found");
    }

    public NotFoundGenre(String msg) {
        this (204, msg);
    }

    public NotFoundGenre(int code, String msg) {
        super(ErrorModel.builder()
                .code(code)
                .msg(msg)
                .timestamp(LocalDateTime.now())
                .build());
    }
}
