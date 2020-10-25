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

    @org.jetbrains.annotations.NotNull
    private List<String> generateListOfNUsers (int usersQuantity) {
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < usersQuantity; i++) {
            usersNames.add("User" + i);
        }
        return usersNames;
    }

    private int generateNumberOfPosts (int postsQuantity) {
        return postsQuantity;
    }

    private int generatorNumberOfComments(int quantityOfComments) {
        return quantityOfComments;
    }

    @Nested
    @DisplayName("Tests for numbers of forum users, posts and comments")
    class TestsForUsers{
        @Test
        void testCalculateNumberOfUsers_100() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultListOfUsers_100 = generateListOfNUsers(100);
            when(statisticsMock.userNames()).thenReturn(resultListOfUsers_100);
            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            int result = forumStatistics.numberOfUsers;

            //Then
            assertEquals(100, result);

        }

        @Test
        void testCalculateNumberOfUsers_0() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultListOfUsers_0 = new ArrayList<>();

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            int forumUsers = forumStatistics.numberOfUsers;

            //Then
            assertEquals(0, forumUsers);
        }

        @Test
        void testCalculateNumberOfPosts_0() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int numberOfPosts = generateNumberOfPosts(0);
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //When
            int forumPosts = forumStatistics.numberOfPosts;
            int expectedResult = 0;

            //Then
            assertEquals(expectedResult, forumPosts);
        }

        @Test
        void testCalculateNumberOfPosts_1000() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int numberOfPosts = generateNumberOfPosts(1000);
            when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //When
            int forumPosts = forumStatistics.numberOfPosts;
            int expectedResult = 1000;

            //Then
            assertEquals(expectedResult, forumPosts);
        }

        @Test
        void testCalculateNumberOfComments_0() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //When
            int forumComments = forumStatistics.numberOfComments;
            int expectedResult = 0;

            //Then
            assertEquals(expectedResult, forumComments);
        }
    }

    @Nested
    @DisplayName("Tests calculate average posts per user")
    class TestsCalculateAveragePostsPerUser {
        @Test
        void testAveragePosts1000_perUsers100() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers100 = generateListOfNUsers(100);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers100);
            when(statisticsMock.postsCount()).thenReturn(1000);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            //When
            double result_users100_posts1000 = forumStatistics.averagePostsPerUser;
            //Then
            assertEquals(10, result_users100_posts1000, 0.01);
        }

        @Test
        void testAveragePosts0_perUsers100() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int numberOfPosts = generateNumberOfPosts(0);
            List<String> resultNumberOfUsers100 = generateListOfNUsers(100);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            double result_users100_posts0 = forumStatistics.averagePostsPerUser;
            //Then
            assertEquals(0.0, result_users100_posts0, 0.01);
        }

        @Test
        void testAveragePosts1000_perUsers0() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int numberOfPosts = generateNumberOfPosts(1000);
            List<String> resultNumberOfUsers0 = generateListOfNUsers(0);

            //When
            forumStatistics.calculateAdvStatistics(statisticsMock);
            double result_posts0_users100 = forumStatistics.averagePostsPerUser;

            //Then
            assertEquals(0.0, result_posts0_users100, 0.01);
        }

        @Test
        void testAveragePosts0_perUsers0() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int postsCount = generateNumberOfPosts(0);
            List<String> resultNumberOfUsers0 = generateListOfNUsers(0);
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //When
            double result_posts0_users0 = forumStatistics.averagePostsPerUser;

            //Then
            assertEquals(0.0, result_posts0_users0, 0.01);
        }
    }

    @Nested
    @DisplayName("Tests calculate average comments per user")
    class TestCalculateAverageCommentsPerUser {
        @Test
        void testAverageCommentsPerUsers() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            List<String> resultNumberOfUsers300 = generateListOfNUsers(300);
            int numberOfComments = generatorNumberOfComments(120);
            when(statisticsMock.userNames()).thenReturn(resultNumberOfUsers300);
            when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //When
            double resultComments120_users300 = forumStatistics.averageCommentsPerUser;

            //Then
            assertEquals(0.4, resultComments120_users300, 0.01);
        }
    }

    @Nested
    @DisplayName("Tests calculate average comments per post.")
    class testAverageCommentsPerPost {
        @Test
        void testAverageCommentsPerPosts_commentsLessThanPosts() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int numberOFComments = generatorNumberOfComments(66);
            int numberOfPosts= generateNumberOfPosts(120);
            when(statisticsMock.commentsCount()).thenReturn(numberOFComments);
            when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            //When
            double result = forumStatistics.averageCommentsPerPost;

            //Then
            assertEquals(0.55, result, 0.01);
        }

        @Test
        void testAverageCommentsPerPosts_postsLessThanComments() {
            //Given
            ForumStatistics forumStatistics = new ForumStatistics();
            int numberOFComments = generatorNumberOfComments(660);
            int numberOfPosts= generateNumberOfPosts(120);
            when(statisticsMock.commentsCount()).thenReturn(numberOFComments);
            when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
            forumStatistics.calculateAdvStatistics(statisticsMock);

            //When
            double result = forumStatistics.averageCommentsPerPost;

            //Then
            assertEquals(5.5, result, 0.01);
        }
    }
}
