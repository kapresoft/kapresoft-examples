package com.kapresoft.articles.api.exception.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@SuppressWarnings("unused")
public class NotFoundResponseException extends ErrorResponseException {

    static final String ERROR_CODE_URI = "https://yoursite.acme.com/error-code";

    public NotFoundResponseException(String errorCode, String detail) {
        super(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()), null);
        setTitle("Object not found.");
        setDetail(detail);
        setTypeFromErrorCode(errorCode);
    }

    void setTypeFromErrorCode(String errorCode) {
        URI type = new DefaultUriBuilderFactory()
                .uriString(ERROR_CODE_URI)
                .pathSegment(errorCode)
                .build();
        setType(type);
    }
}
