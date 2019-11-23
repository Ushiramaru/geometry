package com.epam.implPyramid;

import com.epam.interfacePyramid.FileLineReader;
import com.epam.interfacePyramid.PyramidLineValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class PyramidCSVLineValidatorTest {

    private final static PyramidLineValidator validator = new PyramidCSVLineValidator();
    private final static FileLineReader READER = new PrimitiveFileLineReader();
    private static List<String> lines;

    @BeforeClass
    public static void setUp() {
        lines = READER.readLines("\\geometry\\src\\test\\resources\\pyramids.txt");
    }

    @Test
    public void isValidShouldFalse() {
        Assert.assertFalse(validator.isValid(lines.get(2)));
    }

    @Test
    public void isValidShouldTrue() {
        Assert.assertTrue(validator.isValid(lines.get(0)));
    }

}