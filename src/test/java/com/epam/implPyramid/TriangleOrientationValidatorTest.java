package com.epam.implPyramid;

import com.epam.entity.Point;
import com.epam.entity.Triangle;
import com.epam.interfacePyramid.TriangleValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class TriangleOrientationValidatorTest {

    private final static TriangleValidator validator = new TriangleOrientationValidator();

    @Test
    public void isValidShouldTrue() {
        Triangle triangle = new Triangle(new Point(1, 2, 3), new Point(1, 3, 4), new Point(1, 5, 6));
        Assert.assertTrue(validator.isValid(triangle));
    }

    @Test
    public void isValidShouldFalseWhenEqualsPoints() {
        Triangle triangle = new Triangle(new Point(1, 2, 3), new Point(1, 2, 3), new Point(1, 5, 6));
        Assert.assertFalse(validator.isValid(triangle));
    }

    @Test
    public void isValidShouldFalseWhenNotParallelCoordinatesPlane() {
        Triangle triangle = new Triangle(new Point(2, 2, 3), new Point(1, 3, 4), new Point(1, 5, 6));
        Assert.assertFalse(validator.isValid(triangle));
    }

}