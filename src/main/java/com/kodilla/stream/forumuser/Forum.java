package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> listOfForumUsers;

    public Forum(List<ForumUser> listOfForumUsers) {
        this.listOfForumUsers = listOfForumUsers;
    }

    public List<ForumUser> getUsersList () {
        return new ArrayList<>(listOfForumUsers);
    }
}
