package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    int numberOfUsers;
    int numberOfPosts;
    int numberOfComments;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.userNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if (numberOfUsers == 0) {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        } else {
            averagePostsPerUser = (double) numberOfPosts / numberOfUsers;
            averageCommentsPerUser = (double) numberOfComments / numberOfUsers;
        }
        if (numberOfPosts == 0) {
            averageCommentsPerPost = 0;
        } else {
            averageCommentsPerPost = (double) numberOfComments / numberOfPosts;
        }
    }
}
