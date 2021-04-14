package com.kodilla.patterns2.observer.forum;

import java.util.List;

public class JavaHelpForumTopic extends ForumTopic{

    public JavaHelpForumTopic(String name) {
        super("Java Help Group");
    }

    @Override
    public void addPost(String post) {
        super.addPost(post);
    }

    @Override
    public void registryObserver(Observer observer) {
        super.registryObserver(observer);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
        super.removeObserver(observer);
    }

    @Override
    public List<String> getMessages() {
        return super.getMessages();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
