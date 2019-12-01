package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.interface_pyramid.PointValidator;

public class AreaLimiter implements PointValidator {

    private final static int DEFAULT_MIN_X = -100;
    private final static int DEFAULT_MAX_X = 100;
    private final static int DEFAULT_MIN_Y = -100;
    private final static int DEFAULT_MAX_Y = 100;
    private final static int DEFAULT_MIN_Z = -100;
    private final static int DEFAULT_MAX_Z = 100;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private int minZ;
    private int maxZ;

    public AreaLimiter() {
        minX = DEFAULT_MIN_X;
        maxX = DEFAULT_MAX_X;
        minY = DEFAULT_MIN_Y;
        maxY = DEFAULT_MAX_Y;
        minZ = DEFAULT_MIN_Z;
        maxZ = DEFAULT_MAX_Z;
    }

    public AreaLimiter(int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    @Override
    public boolean isValid(Point point) {
        return point.getX() >= minX && point.getX() <= maxX &&
                point.getY() >= minY && point.getY() <= maxY &&
                point.getZ() >= minZ && point.getZ() <= maxZ;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinZ() {
        return minZ;
    }

    public int getMaxZ() {
        return maxZ;
    }

}