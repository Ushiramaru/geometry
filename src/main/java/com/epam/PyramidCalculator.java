package com.epam;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.entity.Triangle;

import java.util.ArrayList;
import java.util.List;

public class PyramidCalculator {

    public double surfaceArea(Pyramid pyramid) {
        List<Triangle> facets = new ArrayList<>();
        Triangle base = pyramid.getBase();
        facets.add(new Triangle(pyramid.getTop(), base.getPointFirst(), base.getPointSecond()));
        facets.add(new Triangle(pyramid.getTop(), base.getPointSecond(), base.getPointThird()));
        facets.add(new Triangle(pyramid.getTop(), base.getPointThird(), base.getPointFirst()));
        facets.add(base);
        double result = 0;
        for (Triangle facet : facets) {
            result += triangleArea(facet);
        }

        return result;
    }

    public double volume(Pyramid pyramid) {
        Triangle base = pyramid.getBase();
        Point basePointFirst = base.getPointFirst();
        Point basePointSecond = base.getPointSecond();
        Point basePointThird = base.getPointThird();
        Point pyramidTop = pyramid.getTop();

        int h = 0;
        if (basePointFirst.getX() == basePointSecond.getX() && basePointFirst.getX() == basePointThird.getX()) {
            h = Math.abs(basePointFirst.getX() - pyramidTop.getX());
        } else {
            if (basePointFirst.getY() == basePointSecond.getY() && basePointFirst.getY() == basePointThird.getY()) {
                h = Math.abs(basePointFirst.getY() - pyramidTop.getY());
            } else {
                if (basePointFirst.getZ() == basePointSecond.getZ() && basePointFirst.getZ() == basePointThird.getZ()) {
                    h = Math.abs(basePointFirst.getZ() - pyramidTop.getZ());
                }
            }
        }

        return 1.0 / 3 * triangleArea(base) * h;
    }

    public double dissectionRatio(Pyramid pyramid, Triangle triangle) {
        return 0;
    }

    public boolean isBaseBelongsCoordinatePlane(Pyramid pyramid) {
        Triangle base = pyramid.getBase();
        Point basePointFirst = base.getPointFirst();
        Point basePointSecond = base.getPointSecond();
        Point basePointThird = base.getPointThird();

        return basePointFirst.getX() == 0 && basePointSecond.getX() == 0 && basePointThird.getX() == 0 ||
                basePointFirst.getY() == 0 && basePointSecond.getY() == 0 && basePointThird.getY() == 0 ||
                basePointFirst.getZ() == 0 && basePointSecond.getZ() == 0 && basePointThird.getZ() == 0;
    }

    private double triangleArea(Triangle triangle) {
        Point pointFirst = triangle.getPointFirst();
        Point pointSecond = triangle.getPointSecond();
        Point pointThird = triangle.getPointThird();

        Point pointInterimFirst = new Point(pointSecond.getX() - pointFirst.getX(),
                pointSecond.getY() - pointFirst.getY(),
                pointSecond.getZ() - pointFirst.getZ());
        Point pointInterimSecond = new Point(pointThird.getX() - pointFirst.getX(),
                pointThird.getY() - pointFirst.getY(),
                pointThird.getZ() - pointFirst.getZ());
        Point pointInterimThird = new Point(
                pointInterimFirst.getY() * pointInterimSecond.getZ() -
                        pointInterimFirst.getZ() * pointInterimSecond.getY(),
                pointInterimFirst.getX() * pointInterimSecond.getZ() -
                        pointInterimFirst.getZ() * pointInterimSecond.getX(),
                pointInterimFirst.getX() * pointInterimSecond.getY() -
                        pointInterimFirst.getY() * pointInterimSecond.getX());

        return 0.5 * Math.sqrt(Math.pow(pointInterimThird.getX(), 2) +
                Math.pow(pointInterimThird.getY(), 2) +
                Math.pow(pointInterimThird.getZ(), 2));
    }

}