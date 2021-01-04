package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    private final String name;

    public ForumUser() {
        name = "John Smith";
    }

    public String getName() {
        return name;
    }
}
