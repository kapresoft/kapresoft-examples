package com.kapresoft.articles.api.exception.client;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public class NotFoundException extends ApiErrorResponseException {

    public NotFoundException(String errorCode, String statusText) {
        this(errorCode, statusText, null);
    }

    public NotFoundException(String errorCode, String statusText, @Nullable Exception rootCause) {
        super(HttpStatus.NOT_FOUND, rootCause);
        setTitle(statusText);
        setTypeFromErrorCode(errorCode);
    }

}
