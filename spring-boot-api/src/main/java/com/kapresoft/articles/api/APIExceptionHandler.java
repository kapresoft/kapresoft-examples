package com.kapresoft.articles.api;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@SuppressWarnings("NullableProblems")
@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> createResponseEntity(Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        if (!(body instanceof ProblemDetail p)) {
            return super.createResponseEntity(body, headers, statusCode, request);
        }

        p.setInstance(URI.create("/api/users/2"));
        // Add custom details
        p.setProperty("env", "dev");

        return super.createResponseEntity(body, headers, statusCode, request);
    }

}
