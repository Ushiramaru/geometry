package com.epam.interface_pyramid.impl;

import com.epam.entity.Pyramid;
import com.epam.interface_pyramid.PyramidExtractor;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DirectorTest {

    private final static PyramidExtractor EXTRACTOR = new Director(new PrimitiveFileLineReader(),
            new PyramidCSVLineValidator(),
            new PyramidCSVCreator(new AreaLimiter(), new TriangleCSVCreator(new AreaLimiter())),
            new PyramidOrientationValidator(new TriangleOrientationValidator()));
    private final static String PATH = "\\geometry\\src\\test\\resources\\pyramids.txt";
    private final static int EXPECTED_PYRAMID_COUNT = 1;

    @Test
    public void extractTest() {
        List<Pyramid> pyramids = EXTRACTOR.extract(PATH);
        Assert.assertEquals(EXPECTED_PYRAMID_COUNT, pyramids.size());
    }

}