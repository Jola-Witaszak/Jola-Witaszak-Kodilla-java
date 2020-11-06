package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum(initListOfUsers());
        Map<Integer, ForumUser> resultMapOfForumUsers = forum.getUsersList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> Period.between(LocalDate.now(), forumUser.getBirthDate()).getYears() <= 20)
                .filter(forumUser -> forumUser.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        System.out.println("The number of users meeting the search criteria: " + resultMapOfForumUsers.size());
        resultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }

    private static List<ForumUser> initListOfUsers() {
        List<ForumUser> listOfForumUsers = new ArrayList<>();
        listOfForumUsers.add(new ForumUser(101, "Mark-T", 'M', 1995, 12, 12, 0));
        listOfForumUsers.add(new ForumUser(102, "Marta", 'F', 1999, 3, 12, 112));
        listOfForumUsers.add(new ForumUser(103, "Klips", 'M', 2000, 8, 24, 168));
        listOfForumUsers.add(new ForumUser(104, "Kapsel", 'M', 1990, 11, 8, 52));
        listOfForumUsers.add(new ForumUser(105, "Pixel", 'F', 2011, 5, 16, 63));
        listOfForumUsers.add(new ForumUser(106, "Ola", 'F', 2004, 8, 24, 345));
        return listOfForumUsers;
    }
}
