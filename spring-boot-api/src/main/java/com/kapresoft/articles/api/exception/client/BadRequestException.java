package com.kapresoft.articles.api.exception.client;

import org.springframework.http.HttpStatus;

@SuppressWarnings("unused")
public class BadRequestException extends BaseHttpClientErrorException {
    public BadRequestException(String errorCode, String statusText) {
        super(HttpStatus.BAD_REQUEST, errorCode, statusText);
    }

}
