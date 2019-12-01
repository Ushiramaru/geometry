package com.epam.entity;

public class Triangle {

    private Point pointFirst;
    private Point pointSecond;
    private Point pointThird;

    public Triangle(Point[] points) {
        pointFirst = points[0];
        pointSecond = points[1];
        pointThird = points[2];
    }

    public Triangle(Point pointFirst, Point pointSecond, Point pointThird) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
        this.pointThird = pointThird;
    }

    public Point getPointFirst() {
        return pointFirst;
    }

    public Point getPointSecond() {
        return pointSecond;
    }

    public Point getPointThird() {
        return pointThird;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return pointFirst.equals(triangle.pointFirst) &&
                pointSecond.equals(triangle.pointSecond) &&
                pointThird.equals(triangle.pointThird);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * (31 + pointFirst.hashCode()) + pointSecond.hashCode()) + pointThird.hashCode();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "pointFirst=" + pointFirst +
                ", pointSecond=" + pointSecond +
                ", pointThird=" + pointThird +
                '}';
    }

}