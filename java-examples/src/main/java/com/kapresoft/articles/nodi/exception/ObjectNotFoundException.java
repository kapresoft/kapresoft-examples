package com.kapresoft.articles.nodi.exception;

import static java.util.Optional.ofNullable;

@SuppressWarnings("unused")
public class ObjectNotFoundException extends BusinessException {

    public ObjectNotFoundException(String name, Object identity) {
        super("Object [%s] with id[%s] not found.".formatted(
                String.valueOf(name), ofNullable(identity)
                .orElse("null")));
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public ObjectNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
