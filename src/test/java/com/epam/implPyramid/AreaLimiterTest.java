package com.epam.implPyramid;

import com.epam.entity.Point;
import com.epam.interfacePyramid.PointValidator;
import org.junit.Assert;
import org.junit.Test;

public class AreaLimiterTest {

    private final static PointValidator validator = new AreaLimiter();

    @Test
    public void isValidShouldFalse() {
        Point point = new Point(-1000,2,3);
        Assert.assertFalse(validator.isValid(point));
    }

    @Test
    public void isValidShouldTrue() {
        Point point = new Point(-100,2,3);
        Assert.assertTrue(validator.isValid(point));
    }

}