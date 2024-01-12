package com.kapresoft.articles.nodi.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
public class User {
    Long id;
    String email;
    String first;
    String last;
    boolean active;
}

