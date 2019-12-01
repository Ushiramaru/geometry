package com.epam.interface_pyramid.impl;

import com.epam.entity.Point;
import com.epam.entity.Triangle;
import com.epam.interface_pyramid.TriangleValidator;
import org.junit.Assert;
import org.junit.Test;

public class TriangleOrientationValidatorTest {

    private final static TriangleValidator VALIDATOR = new TriangleOrientationValidator();

    @Test
    public void isValidTestShouldTrue() {
        Triangle triangle = new Triangle(new Point(1, 2, 3), new Point(1, 3, 4), new Point(1, 5, 6));
        Assert.assertTrue(VALIDATOR.isValid(triangle));
    }

    @Test
    public void isValidTestShouldFalseWhenEqualsPoints() {
        Triangle triangle = new Triangle(new Point(1, 2, 3), new Point(1, 2, 3), new Point(1, 5, 6));
        Assert.assertFalse(VALIDATOR.isValid(triangle));
    }

    @Test
    public void isValidTestShouldFalseWhenNotParallelCoordinatesPlane() {
        Triangle triangle = new Triangle(new Point(2, 2, 3), new Point(1, 3, 4), new Point(1, 5, 6));
        Assert.assertFalse(VALIDATOR.isValid(triangle));
    }

}