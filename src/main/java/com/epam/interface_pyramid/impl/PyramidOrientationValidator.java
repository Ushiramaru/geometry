package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.entity.Triangle;
import com.epam.interface_pyramid.PyramidValidator;
import com.epam.interface_pyramid.TriangleValidator;

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
        Point pointFirst = base.getPointFirst();
        Point pointSecond = base.getPointSecond();
        Point pointThird = base.getPointThird();
        Point top = pyramid.getTop();
        return (pointFirst.getX() == pointSecond.getX() &&
                pointFirst.getX() == pointThird.getX() &&
                pointFirst.getX() != top.getX()) ||
               (pointFirst.getY() == pointSecond.getY() &&
                pointFirst.getY() == pointThird.getY() &&
                pointFirst.getY() != top.getY()) ||
               (pointFirst.getZ() == pointSecond.getZ() &&
                pointFirst.getZ() == pointThird.getZ() &&
                pointFirst.getZ() != top.getZ());
    }

    public TriangleValidator getBaseValidator() {
        return baseValidator;
    }

}