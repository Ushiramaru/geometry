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
        facets.add(new Triangle(pyramid.getTop(), base.getPoint1(), base.getPoint2()));
        facets.add(new Triangle(pyramid.getTop(), base.getPoint2(), base.getPoint3()));
        facets.add(new Triangle(pyramid.getTop(), base.getPoint3(), base.getPoint1()));
        facets.add(base);
        double result = 0;
        for (Triangle facet : facets) {
            result += triangleArea(facet);
        }
        return result;
    }

    public double volume(Pyramid pyramid) throws CalculatorException {
        Triangle base = pyramid.getBase();
        int h;
        if (base.getPoint1().getX() == base.getPoint2().getX() && base.getPoint1().getX() == base.getPoint3().getX()) {
            h = Math.abs(base.getPoint1().getX() - pyramid.getTop().getX());
        } else {
            if (base.getPoint1().getY() == base.getPoint2().getY() && base.getPoint1().getY() == base.getPoint3().getY()) {
                h = Math.abs(base.getPoint1().getY() - pyramid.getTop().getY());
            } else {
                if (base.getPoint1().getZ() == base.getPoint2().getZ() && base.getPoint1().getZ() == base.getPoint3().getZ()) {
                    h = Math.abs(base.getPoint1().getZ() - pyramid.getTop().getZ());
                } else {
                    throw new CalculatorException("Invalid pyramid");
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
        return base.getPoint1().getX() == 0 && base.getPoint2().getX() == 0 && base.getPoint3().getX() == 0 ||
                base.getPoint1().getY() == 0 && base.getPoint2().getY() == 0 && base.getPoint3().getY() == 0 ||
                base.getPoint1().getZ() == 0 && base.getPoint2().getZ() == 0 && base.getPoint3().getZ() == 0;
    }

    private double triangleArea(Triangle triangle) {
        Point point = new Point(triangle.getPoint2().getX() - triangle.getPoint1().getX(),
                triangle.getPoint2().getY() - triangle.getPoint1().getY(),
                triangle.getPoint2().getZ() - triangle.getPoint1().getZ());
        Point point1 = new Point(triangle.getPoint3().getX() - triangle.getPoint1().getX(),
                triangle.getPoint3().getY() - triangle.getPoint1().getY(),
                triangle.getPoint3().getZ() - triangle.getPoint1().getZ());
        Point point2 = new Point(point.getY() * point1.getZ() - point.getZ() * point1.getY(),
                point.getX() * point1.getZ() - point.getZ() * point1.getX(),
                point.getX() * point1.getY() - point.getY() * point1.getX());
        return 0.5 * Math.sqrt(Math.pow(point2.getX(), 2) + Math.pow(point2.getY(), 2) + Math.pow(point2.getZ(), 2));
    }

}
