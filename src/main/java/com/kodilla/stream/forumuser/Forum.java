package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> listOfForumUsers = new ArrayList<>();

    public Forum() {
        listOfForumUsers.add(new ForumUser(101, "Mark-T", 'M', 1995,12,12,63));
        listOfForumUsers.add(new ForumUser(102, "Marta", 'F', 1999,3,12, 112));
        listOfForumUsers.add(new ForumUser(103, "Klips", 'M', 2000, 8, 24, 168));
        listOfForumUsers.add(new ForumUser(104, "Kapsel", 'M', 2005, 11, 8, 52));
        listOfForumUsers.add(new ForumUser(105, "Pixel", 'F', 2011, 5, 16, 63));
        listOfForumUsers.add(new ForumUser(106, "Ola", 'F', 2004, 8, 24, 345));
    }

    public List<ForumUser> getUsersList () {
        return new ArrayList<>(listOfForumUsers);
    }
}
