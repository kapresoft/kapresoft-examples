package com.kapresoft.articles.api.exception.client2;

@SuppressWarnings("unused")
public class InsufficientFundsException2 extends BadRequestException2 {
    public InsufficientFundsException2(String msg) {
        super(msg, "insufficient-funds");
    }

    public InsufficientFundsException2(String msg, Throwable cause) {
        super(msg, cause);
    }

}
