package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests have been performed.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Performing test # " + testCounter);
    }

    private List<String> generateListOfNUsers (int usersQuantity) {
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < usersQuantity; i++) {
            usersNames.add("User" + i);
        }
        return usersNames;
    }

    @Nested
    @DisplayName("Tests for numbers of forum users, posts and comments")
    class TestsForUsers{
        @Test
        void shouldReturnNumberOfUsersHundred() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultListOfUsers_100 = generateListOfNUsers(100);
            when(statisticsMock.userNames()).thenReturn(resultListOfUsers_100);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            int result = forumStatistics.numberOfUsers;
            assertEquals(100, result);

        }

        @Test
        void shouldReturnNumberOfUsersZero() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultListOfUsers_0 = new ArrayList<>();
            when(statisticsMock.userNames()).thenReturn(resultListOfUsers_0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            int forumUsers = forumStatistics.numberOfUsers;
            assertEquals(0, forumUsers);
        }

        @Test
        void shouldReturnNumberOfPostsZero() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            int forumPosts = forumStatistics.numberOfPosts;
            assertEquals(0, forumPosts);
        }

        @Test
        void shouldReturnNumberOfPostsThousand() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            int forumPosts = forumStatistics.numberOfPosts;
            assertEquals(1000, forumPosts);
        }

        @Test
        void shouldReturnNumberOfCommentsZero() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            int forumComments = forumStatistics.numberOfComments;
            assertEquals(0, forumComments);
        }
    }

    @Nested
    @DisplayName("Tests calculate average posts per user")
    class TestsCalculateAveragePostsPerUser {
        @Test
        void shouldReturnAveragePostsPerUser() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers100 = generateListOfNUsers(100);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers100);
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double result_users100_posts1000 = forumStatistics.averagePostsPerUser;
            assertEquals(10, result_users100_posts1000, 0.01);
        }

        @Test
        void shouldReturnAveragePostsPerHundredUsersWhenZeroPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers100 = generateListOfNUsers(100);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers100);
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double result_users100_posts0 = forumStatistics.averagePostsPerUser;
            assertEquals(0.0, result_users100_posts0, 0.01);
        }

        @Test
        void shouldReturnAverageZeroPostsPerUserWhenZeroUsersAndThousandPosts () {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers0 = generateListOfNUsers(0);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double result_posts0_users100 = forumStatistics.averagePostsPerUser;
            assertEquals(0.0, result_posts0_users100, 0.01);
        }

        @Test
        void shouldReturnZeroAveragePostsPerUserWhenZeroUsers() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers0 = generateListOfNUsers(0);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers0);
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double resultPosts0_users0 = forumStatistics.averagePostsPerUser;
            assertEquals(0.0, resultPosts0_users0, 0.01);
        }
    }

    @Nested
    @DisplayName("Tests calculate average comments per user")
    class TestCalculateAverageCommentsPerUser {
        @Test
        void shouldReturnCorrectAverageNumberOfCommentsPerUser() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers4 = generateListOfNUsers(4);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers4);
            when(statisticsMock.commentsCount()).thenReturn(10);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double resultComments10_users4 = forumStatistics.averageCommentsPerUser;
            assertEquals(2.5, resultComments10_users4, 0.01);
        }
    }

    @Nested
    @DisplayName("Tests calculate average comments per post.")
    class testAverageCommentsPerPost {
        @Test
        void shouldReturnCorrectAverageCommentsPerPostsWhenCommentsLessThanPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(2);
            when(statisticsMock.postsCount()).thenReturn(4);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double result = forumStatistics.averageCommentsPerPost;
            assertEquals(0.5, result, 0.01);
        }

        @Test
        void shouldReturnCorrectAverageCommentsPerPostsWhenCommentsMoreThanPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            when(statisticsMock.commentsCount()).thenReturn(3);
            when(statisticsMock.postsCount()).thenReturn(2);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            double result = forumStatistics.averageCommentsPerPost;
            assertEquals(1.5, result, 0.01);
        }
    }
}
