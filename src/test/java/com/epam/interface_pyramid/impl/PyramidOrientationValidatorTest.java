package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.entity.Triangle;
import com.epam.interface_pyramid.PyramidValidator;
import org.junit.Assert;
import org.junit.Test;

public class PyramidOrientationValidatorTest {

    private final static PyramidValidator VALIDATOR = new PyramidOrientationValidator(new TriangleOrientationValidator());

    @Test
    public void isValidTestShouldTrue() {
        Pyramid pyramid = new Pyramid(new Point(1, 1, 1), new Triangle(new Point(1, 2, 3), new Point(4, 2, 7), new Point(7, 2, 4)));
        Assert.assertTrue(VALIDATOR.isValid(pyramid));
    }

    @Test
    public void isValidTestShouldFalseWhenTopInOnePlaneWithBase() {
        Pyramid pyramid = new Pyramid(new Point(1, 2, 1), new Triangle(new Point(1, 2, 3), new Point(4, 2, 7), new Point(7, 2, 4)));
        Assert.assertFalse(VALIDATOR.isValid(pyramid));
    }

}