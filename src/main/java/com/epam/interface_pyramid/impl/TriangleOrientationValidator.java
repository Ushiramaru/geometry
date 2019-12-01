package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.entity.Triangle;
import com.epam.interface_pyramid.TriangleValidator;

public class TriangleOrientationValidator implements TriangleValidator {

    @Override
    public boolean isValid(Triangle triangle) {
        return isParallelCoordinatePlane(triangle) && isDifferentPoints(triangle);
    }

    private boolean isParallelCoordinatePlane(Triangle triangle) {
        Point pointFirst = triangle.getPointFirst();
        Point pointSecond = triangle.getPointSecond();
        Point pointThird = triangle.getPointThird();

        return pointFirst.getX() == pointSecond.getX() && pointFirst.getX() == pointThird.getX() ||
                pointFirst.getY() == pointSecond.getY() && pointFirst.getY() == pointThird.getY() ||
                pointFirst.getZ() == pointSecond.getZ() && pointFirst.getZ() == pointThird.getZ();
    }

    private boolean isDifferentPoints(Triangle triangle) {
        Point pointFirst = triangle.getPointFirst();
        Point pointSecond = triangle.getPointSecond();
        Point pointThird = triangle.getPointThird();

        return !(pointFirst.equals(pointSecond) ||
                pointFirst.equals(pointThird) ||
                pointSecond.equals(pointThird));
    }

}