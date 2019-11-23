package com.epam.implPyramid;

import com.epam.entity.Point;
import com.epam.entity.Pyramid;
import com.epam.entity.Triangle;
import com.epam.interfacePyramid.PyramidValidator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PyramidOrientationValidatorTest {

    private final static PyramidValidator validator = new PyramidOrientationValidator(new TriangleOrientationValidator());

    @Test
    public void isValidShouldTrue() {
        Pyramid pyramid = new Pyramid(new Point(1, 1, 1), new Triangle(new Point(1, 2, 3), new Point(4, 2, 7), new Point(7, 2, 4)));
        Assert.assertTrue(validator.isValid(pyramid));
    }

    @Test
    public void isValidShouldFalseWhenTopInOnePlaneWithBase() {
        Pyramid pyramid = new Pyramid(new Point(1, 2, 1), new Triangle(new Point(1, 2, 3), new Point(4, 2, 7), new Point(7, 2, 4)));
        Assert.assertFalse(validator.isValid(pyramid));
    }

}