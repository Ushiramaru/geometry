package com.epam.repository.specification.impl;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifiable;
import com.epam.repository.specification.Specification;

public class SpecificationPyramidByTopPoinsYRange implements Specification<PyramidIdentifiable> {

    private int minY;
    private int maxY;

    public SpecificationPyramidByTopPoinsYRange(int minY, int maxY) {
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean specified(PyramidIdentifiable object) {
        Point point = object.getTop();
        int topY = point.getY();
        return topY >= minY && topY <= maxY;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
}