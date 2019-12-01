package com.epam.interface_pyramid.impl;

import com.epam.interface_pyramid.TriangleCreator;
import org.junit.Assert;
import org.junit.Test;

public class TriangleCSVCreatorTest {

    private final static TriangleCreator creator = new TriangleCSVCreator(new AreaLimiter());
    private final static String TRUE_TRIANGLE_LINE = "-1;22;3;1;42;3;-1;2;0;";
    private final static String FALSE_TRIANGLE_LINE = "-1;222;3;1;42;3;-1;2;0;";

    @Test
    public void createTestShouldEmptyOptional() {
        Assert.assertFalse(creator.create(FALSE_TRIANGLE_LINE).isPresent());
    }

    @Test
    public void createTestShouldNotEmptyOptional() {
        Assert.assertTrue(creator.create(TRUE_TRIANGLE_LINE).isPresent());
    }

}