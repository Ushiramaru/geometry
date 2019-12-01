package com.epam.observer;

public interface Observable<T> {

    void addObserver(Observer<T> observer);

    void deleteObserver(Observer<T> observer);

    void inform();

}