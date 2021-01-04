package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User millenials = new Millenials("Millenials");
        User someoneY = new YGeneration("Ypsilon");
        User antZet = new ZGeneration("Zet Ant");
        //When
        String postMill = millenials.sharePost();
        String postY = someoneY.sharePost();
        String postZ = antZet.sharePost();
        //Then
        assertEquals("Facebook post shared", postMill);
        assertEquals("Twitter post shared", postY);
        assertEquals("Snapchat post shared", postZ);

    }
    @Test
    void testIndividualSharingStrategy() {
        //Given
        User antZet = new ZGeneration("Ant Zet");
        //When
        antZet.setSocialPublisher(new TwitterPublisher());
        String newMessenger = antZet.sharePost();
        //Then
        assertEquals("Twitter post shared", newMessenger);
    }
}
