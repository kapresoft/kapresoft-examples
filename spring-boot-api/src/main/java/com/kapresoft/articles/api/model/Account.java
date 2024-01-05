package com.kapresoft.articles.api.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@Builder
public class Account {
    String accountNumber;
    String accountHolder;
    double balance;
}
