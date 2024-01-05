package com.kapresoft.articles.api;

import lombok.Getter;

import org.springframework.context.ApplicationEvent;

@Getter
@SuppressWarnings("unused")
public class BlockedListEvent extends ApplicationEvent {
    private final String address;
    private final String content;

    public BlockedListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

}
