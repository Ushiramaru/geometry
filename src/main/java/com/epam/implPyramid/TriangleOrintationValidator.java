package com.epam.implPyramid;

import com.epam.entity.Triangle;
import com.epam.interfacePyramid.TriangleValidator;

public final class TriangleOrintationValidator implements TriangleValidator {

    @Override
    public boolean isValid(Triangle triangle) {
        return isParallelCoordinatePlane(triangle) && isDifferentPoints(triangle);
    }

    private boolean isParallelCoordinatePlane(Triangle triangle) {
        return triangle.getPoint1().getX() == triangle.getPoint2().getX() && triangle.getPoint1().getX() == triangle.getPoint3().getX() ||
                triangle.getPoint1().getY() == triangle.getPoint2().getY() && triangle.getPoint1().getY() == triangle.getPoint3().getY() ||
                triangle.getPoint1().getZ() == triangle.getPoint2().getZ() && triangle.getPoint1().getZ() == triangle.getPoint3().getZ();
    }

    private boolean isDifferentPoints(Triangle triangle) {
        return !(triangle.getPoint1().equals(triangle.getPoint2()) ||
                triangle.getPoint1().equals(triangle.getPoint3()) ||
                triangle.getPoint2().equals(triangle.getPoint3()));
    }

}
