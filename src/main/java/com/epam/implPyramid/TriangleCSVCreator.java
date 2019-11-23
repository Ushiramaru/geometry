package com.epam.implPyramid;

import com.epam.entity.Point;
import com.epam.entity.Triangle;
import com.epam.interfacePyramid.PointValidator;
import com.epam.interfacePyramid.TriangleCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class TriangleCSVCreator implements TriangleCreator {

    private final static String DELIMITER = ";";
    private final static int DIMENSION_COUNT = 3;
    private final static int POINTS_COUNT = 3;

    private PointValidator pointValidator;

    public TriangleCSVCreator(PointValidator pointValidator) {
        this.pointValidator = pointValidator;
    }

    @Override
    public Optional<Triangle> create(String line) {
        String[] coordinates = line.split(DELIMITER);
        List<Point> points = new ArrayList<>();
        Point point;
        for (int i = 0; i < coordinates.length; i += DIMENSION_COUNT) {
            point = new Point(Integer.valueOf(coordinates[i]), Integer.valueOf(coordinates[i + 1]), Integer.valueOf(coordinates[i + 2]));
            if (!pointValidator.isValid(point)) {
                break;
            }
            points.add(point);
        }

        Optional<Triangle> optionalTriangle;
        if (points.size() == POINTS_COUNT) {
            optionalTriangle = Optional.of(new Triangle((Point[]) points.toArray()));
        } else {
            optionalTriangle = Optional.empty();
        }

        return optionalTriangle;
    }

    public PointValidator getPointValidator() {
        return pointValidator;
    }

}
