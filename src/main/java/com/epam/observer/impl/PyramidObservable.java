package com.epam.observer.impl;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifiable;
import com.epam.entity.Triangle;
import com.epam.observer.Observable;
import com.epam.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservable extends PyramidIdentifiable implements Observable<PyramidObservable> {

    private List<Observer<PyramidObservable>> observers = new ArrayList<>();

    public PyramidObservable(Point top, Triangle base, int id) {
        super(top, base, id);
    }

    @Override
    public void addObserver(Observer<PyramidObservable> observer) {
        observer.update(this);
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer<PyramidObservable> observer) {
        observers.remove(observer);
    }

    @Override
    public void inform() {
        for (Observer<PyramidObservable> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void setTop(Point top) {
        super.setTop(top);
        inform();
    }

    @Override
    public void setBase(Triangle base) {
        super.setBase(base);
        inform();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return 31 + super.hashCode();
    }

}