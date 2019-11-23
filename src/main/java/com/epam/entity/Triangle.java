package com.epam.entity;

public class Triangle {

    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point[] points) {
        point1 = points[0];
        point2 = points[1];
        point3 = points[2];
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return point1.equals(triangle.point1) &&
                point2.equals(triangle.point2) &&
                point3.equals(triangle.point3);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * (31 + point1.hashCode()) + point2.hashCode()) + point3.hashCode();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }

}
