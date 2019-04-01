package bom.spring.study.exception;

import com.sun.tools.corba.se.idl.constExpr.Not;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j  //logging
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorModel> exceptionController(BaseException exception) throws RuntimeException {
        ErrorModel error = exception.error;
        log.error(error.getMsg());

        switch (error.getCode()) {
            case 204:
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error);
            case 400:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error);
    }
}
