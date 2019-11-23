package com.epam.implPyramid;

import com.epam.entity.Pyramid;
import com.epam.interfacePyramid.PyramidExtractor;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DirectorTest {

    private final static PyramidExtractor extractor = new Director(new PrimitiveFileLineReader(),
            new PyramidCSVLineValidator(),
            new PyramidCSVCreator(new AreaLimiter(), new TriangleCSVCreator(new AreaLimiter())),
            new PyramidOrientationValidator(new TriangleOrientationValidator()));
    private final static String path = "\\geometry\\src\\test\\resources\\pyramids.txt";
    private final static int EXPECTED_PYRAMID_COUNT = 1;

    @Test
    public void extract() {
        List<Pyramid> pyramids = extractor.extract(path);
        Assert.assertEquals(EXPECTED_PYRAMID_COUNT, pyramids.size());
    }

}