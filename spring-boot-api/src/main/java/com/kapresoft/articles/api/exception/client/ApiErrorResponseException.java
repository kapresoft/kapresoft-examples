package com.kapresoft.articles.api.exception.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@SuppressWarnings("unused")
public class ApiErrorResponseException extends ErrorResponseException {

    static final String ERROR_CODE_URI = "https://yoursite.acme.com/error-code";

    public ApiErrorResponseException(HttpStatusCode status) {
        super(status);
    }

    public ApiErrorResponseException(HttpStatusCode status, Throwable cause) {
        super(status, cause);
    }

    public ApiErrorResponseException(HttpStatusCode status, ProblemDetail body, Throwable cause) {
        super(status, body, cause);
    }

    public ApiErrorResponseException(HttpStatusCode status, ProblemDetail body, Throwable cause, String messageDetailCode, Object[] messageDetailArguments) {
        super(status, body, cause, messageDetailCode, messageDetailArguments);
    }

    void setTypeFromErrorCode(String errorCode) {
        URI type = new DefaultUriBuilderFactory()
                .uriString(ERROR_CODE_URI)
                .pathSegment(errorCode)
                .build();
        setType(type);
    }
}
