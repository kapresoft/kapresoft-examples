package com.kapresoft.articles.api.exception.client;

import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@Getter
public class BaseHttpClientErrorException extends HttpClientErrorException {

    private final String errorCode;

    public BaseHttpClientErrorException(HttpStatus statusCode, String errorCode, String statusText) {
        super(statusCode, statusText);
        this.errorCode = errorCode;
    }

}
