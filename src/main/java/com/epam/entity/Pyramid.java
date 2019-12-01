package com.epam.entity;

public class Pyramid {

    private Point top;
    private Triangle base;

    public Pyramid(Point top, Triangle base) {
        this.top = top;
        this.base = base;
    }

    public Point getTop() {
        return top;
    }

    public Triangle getBase() {
        return base;
    }

    public void setTop(Point top) {
        this.top = top;
    }

    public void setBase(Triangle base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) o;
        return top.equals(pyramid.top) &&
                base.equals(pyramid.base);
    }

    @Override
    public int hashCode() {
        return 31 * (31 + top.hashCode()) + base.hashCode();
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "top=" + top +
                ", base=" + base +
                '}';
    }

}