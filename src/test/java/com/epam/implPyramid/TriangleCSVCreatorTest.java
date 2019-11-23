package com.epam.implPyramid;

import com.epam.interfacePyramid.TriangleCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleCSVCreatorTest {

    private final static TriangleCreator creator = new TriangleCSVCreator(new AreaLimiter());
    private final static String TRUE_TRIANGLE_LINE = "-1;22;3;1;42;3;-1;2;0;";
    private final static String FALSE_TRIANGLE_LINE = "-1;222;3;1;42;3;-1;2;0;";

    @Test
    public void createShouldEmptyOptional() {
        Assert.assertFalse(creator.create(FALSE_TRIANGLE_LINE).isPresent());
    }

    @Test
    public void createShouldNotEmptyOptional() {
        Assert.assertTrue(creator.create(TRUE_TRIANGLE_LINE).isPresent());
    }

}