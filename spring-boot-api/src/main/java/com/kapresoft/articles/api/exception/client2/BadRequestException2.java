package com.kapresoft.articles.api.exception.client2;

import org.springframework.core.NestedRuntimeException;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@ResponseStatus(BAD_REQUEST)
public class BadRequestException2 extends NestedRuntimeException {
    private String errorCode;

    public BadRequestException2(String msg) {
        this(msg, "generic");
    }

    public BadRequestException2(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BadRequestException2(String msg, Throwable cause) {
        super(msg, cause);
    }

}
