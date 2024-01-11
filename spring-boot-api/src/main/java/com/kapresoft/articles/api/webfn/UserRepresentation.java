package com.kapresoft.articles.api.webfn;

import lombok.Builder;
import lombok.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kapresoft.articles.api.model.User;


@SuppressWarnings("unused")
@Value
public class UserRepresentation {

    @JsonIgnore
    User user;

    String link;

    @Builder
    public UserRepresentation(User user, @JsonProperty("link") String link) {
        this.user = user;
        this.link = link;
    }

    public Long getId() {
        return getUser().getId();
    }

    public String getEmail() {
        return getUser().getEmail();
    }

    public String getFirst() {
        return getUser().getFirst();
    }

    public String getLast() {
        return getUser().getLast();
    }

    public boolean isActive() {
        return getUser().isActive();
    }

}
