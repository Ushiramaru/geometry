package com.epam.implPyramid;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.entity.Triangle;
import com.epam.interfacePyramid.PyramidValidator;
import com.epam.interfacePyramid.TriangleValidator;

public class PyramidOrientationValidator implements PyramidValidator {

    private TriangleValidator baseValidator;

    public PyramidOrientationValidator(TriangleValidator baseValidator) {
        this.baseValidator = baseValidator;
    }

    @Override
    public boolean isValid(Pyramid pyramid) {
        return baseValidator.isValid(pyramid.getBase()) && isTopNotBelongsBase(pyramid);
    }

    private boolean isTopNotBelongsBase(Pyramid pyramid) {
        Triangle base = pyramid.getBase();
        Point point1 = base.getPoint1();
        Point point2 = base.getPoint2();
        Point point3 = base.getPoint3();
        return (point1.getX() == point2.getX() &&
                point1.getX() == point3.getX() &&
                point1.getX() != pyramid.getTop().getX()) ||
               (point1.getY() == point2.getY() &&
                point1.getY() == point3.getY() &&
                point1.getY() != pyramid.getTop().getY()) ||
               (point1.getZ() == point2.getZ() &&
                point1.getZ() == point3.getZ() &&
                point1.getZ() != pyramid.getTop().getZ());
    }

    public TriangleValidator getBaseValidator() {
        return baseValidator;
    }

}
