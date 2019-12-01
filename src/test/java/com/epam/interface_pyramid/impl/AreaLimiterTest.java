package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.interface_pyramid.PointValidator;
import org.junit.Assert;
import org.junit.Test;

public class AreaLimiterTest {

    private final static PointValidator VALIDATOR = new AreaLimiter();
    private final static int VALID_X_VALUE = -100;
    private final static int INVALID_X_VALUE = -1000;
    private final static int VALID_Y_VALUE = 2;
    private final static int VALID_Z_VALUE = 3;

    @Test
    public void isValidTestShouldFalse() {
        Point point = new Point(INVALID_X_VALUE, VALID_Y_VALUE, VALID_Z_VALUE);
        Assert.assertFalse(VALIDATOR.isValid(point));
    }

    @Test
    public void isValidTestShouldTrue() {
        Point point = new Point(VALID_X_VALUE, VALID_Y_VALUE, VALID_Z_VALUE);
        Assert.assertTrue(VALIDATOR.isValid(point));
    }

}