package com.epam.interface_pyramid.impl;

import com.epam.interface_pyramid.PointValidator;
import com.epam.interface_pyramid.PyramidCreator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PyramidCSVCreatorTest {

    private static PyramidCreator creator;
    private final static String TRUE_TRIANGLE_LINE = "-1;22;3;-1;22;3;1;42;3;-1;2;0;";
    private final static String FALSE_TRIANGLE_LINE = "-1;22;3;-1;222;3;1;42;3;-1;2;0;";

    @BeforeClass
    public static void setUp() {
        PointValidator pointValidator = new AreaLimiter();
        creator = new PyramidCSVCreator(pointValidator, new TriangleCSVCreator(pointValidator));
    }

    @Test
    public void createTestShouldEmptyOptional() {
        Assert.assertFalse(creator.create(FALSE_TRIANGLE_LINE).isPresent());
    }

    @Test
    public void createTestShouldNotEmptyOptional() {
        Assert.assertTrue(creator.create(TRUE_TRIANGLE_LINE).isPresent());
    }

}