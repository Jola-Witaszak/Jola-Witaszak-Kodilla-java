package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final char gender;
    private final LocalDate birthDate;
    private final int postsCount;

    public ForumUser(final int userId, final String username, final char gender, int yearOfBirth, int monthOfBirth, int dayOfBirth, final int postsCount) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsCount = postsCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + username + '\'' +
                ", sex=" + gender +
                ", birthDate=" + birthDate +
                ", postsCount=" + postsCount +
                '}';
    }
}
