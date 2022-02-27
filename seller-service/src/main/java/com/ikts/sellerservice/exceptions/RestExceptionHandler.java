package com.ikts.sellerservice.exceptions;

import com.ikts.sellerservice.model.SwaggerError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Annotation[] annotations = ex.getClass().getAnnotations();
        for(Annotation annotation: annotations) {
            if(annotation instanceof ResponseStatus)
                httpStatus = ((ResponseStatus) annotation).value();
        }
        log.error("Exception handled: " + ex);
        return ResponseEntity
                .status(httpStatus)
                .body(SwaggerError.builder()
                .errorCode(httpStatus.value())
                .timestamp(LocalDateTime.now().getLong(ChronoField.CLOCK_HOUR_OF_DAY))
                        .message(ex.getMessage())
                        .build());
    }
}
