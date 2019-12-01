package com.epam.interface_pyramid.impl;

import com.epam.interface_pyramid.FileLineReader;
import com.epam.interface_pyramid.PyramidLineValidator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class PyramidCSVLineValidatorTest {

    private final static PyramidLineValidator VALIDATOR = new PyramidCSVLineValidator();
    private final static FileLineReader READER = new PrimitiveFileLineReader();
    private final static String PATH = "\\geometry\\src\\test\\resources\\pyramids.txt";
    private static List<String> lines;

    @BeforeClass
    public static void setUp() {
        lines = READER.readLines(PATH);
    }

    @Test
    public void isValidTestShouldFalse() {
        Assert.assertFalse(VALIDATOR.isValid(lines.get(2)));
    }

    @Test
    public void isValidTestShouldTrue() {
        Assert.assertTrue(VALIDATOR.isValid(lines.get(0)));
    }

}