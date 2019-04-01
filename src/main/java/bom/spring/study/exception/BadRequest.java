package bom.spring.study.exception;

import java.time.LocalDateTime;

public class BadRequest extends BaseException{
    public BadRequest() {
        this("Bad Request");
    }

    public BadRequest(String msg) {
        this(400, msg);
    }

    public BadRequest(int code, String msg) {
        super(ErrorModel.builder()
                .code(code)
                .msg(msg)
                .timestamp(LocalDateTime.now())
                .build());
    }
}
