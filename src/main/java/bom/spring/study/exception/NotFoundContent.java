package bom.spring.study.exception;

import java.time.LocalDateTime;

public class NotFoundContent extends BaseException {

    public NotFoundContent() {
        this ("Contents Not Found");
    }

    public NotFoundContent(String msg) {
        this (204, msg);
    }

    public NotFoundContent(int code, String msg) {
        super(ErrorModel.builder()
                .code(code)
                .msg(msg)
                .timestamp(LocalDateTime.now())
                .build());
    }

}
