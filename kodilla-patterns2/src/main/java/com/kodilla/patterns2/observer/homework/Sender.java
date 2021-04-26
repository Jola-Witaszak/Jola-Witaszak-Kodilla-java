package com.kodilla.patterns2.observer.homework;

public interface Sender {
    void addReceiver(Receiver receiver);
    void notifyReceives();
    void removeReceiver(Receiver receiver);
}
