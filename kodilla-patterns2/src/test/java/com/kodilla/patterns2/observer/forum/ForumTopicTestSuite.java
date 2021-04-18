package com.kodilla.patterns2.observer.forum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForumTopicTestSuite {

    @Test
    void testUpdate() {
        //Given
        ForumTopic javaHelpForum = new ForumTopic("Java Help Forum");
        ForumTopic javaToolsForum = new ForumTopic("Java Tools Forum");
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar= new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForum.registryObserver(johnSmith);
        javaToolsForum.registryObserver(ivoneEscobar);
        javaHelpForum.registryObserver(jessiePinkman);
        javaToolsForum.registryObserver(jessiePinkman);
        //When
        javaHelpForum.addPost("Hi everyoe! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaToolsForum.addPost("Help pls, my MySQL db doesn't want to work :(");
        javaHelpForum.addPost("Why while? Is it better?");
        javaToolsForum.addPost("When I try to log in I got 'bad credentials' message");
        //Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
    }
}