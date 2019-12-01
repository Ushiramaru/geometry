package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.entity.Triangle;
import com.epam.interface_pyramid.PointValidator;
import com.epam.interface_pyramid.PyramidCreator;
import com.epam.interface_pyramid.TriangleCreator;

import java.util.Optional;

public final class PyramidCSVCreator implements PyramidCreator {

    private final static String DELIMITER = ";";

    private PointValidator pointValidator;
    private TriangleCreator triangleCreator;

    public PyramidCSVCreator(PointValidator pointValidator, TriangleCreator triangleCreator) {
        this.pointValidator = pointValidator;
        this.triangleCreator = triangleCreator;
    }

    @Override
    public Optional<Pyramid> create(String line) {
        int delimiterIndex = line.indexOf(DELIMITER);
        delimiterIndex = line.indexOf(DELIMITER, delimiterIndex + 1);
        delimiterIndex = line.indexOf(DELIMITER, delimiterIndex + 1);
        String topLine = line.substring(0, delimiterIndex);
        String[] topCoordinates = topLine.split(DELIMITER);
        Point top = new Point(Integer.valueOf(topCoordinates[0]), Integer.valueOf(topCoordinates[1]), Integer.valueOf(topCoordinates[2]));
        Optional<Pyramid> optionalPyramid;
        if (pointValidator.isValid(top)) {
            Optional<Triangle> optionalTriangle = triangleCreator.create(line.substring(delimiterIndex + 1));
            if (optionalTriangle.isPresent()) {
                optionalPyramid = Optional.of(new Pyramid(top, optionalTriangle.get()));
            } else {
                optionalPyramid = Optional.empty();
            }
        } else {
            optionalPyramid = Optional.empty();
        }

        return optionalPyramid;
    }

    public PointValidator getPointValidator() {
        return pointValidator;
    }

    public TriangleCreator getTriangleCreator() {
        return triangleCreator;
    }

}