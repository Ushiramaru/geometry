package com.epam.interface_pyramid.impl;

import com.epam.interface_pyramid.FileLineReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class PrimitiveFileLineReaderTest {

    private final static FileLineReader READER = new PrimitiveFileLineReader();
    private static List<String> lines;
    private final static int EXPECTED_LINES_COUNT = 3;
    private final static String PATH = "\\geometry\\src\\test\\resources\\pyramids.txt";

    @BeforeClass
    public static void setUp() {
        lines = READER.readLines(PATH);
    }

    @Test
    public void readLinesTestShouldThreeLines() {
        Assert.assertEquals(EXPECTED_LINES_COUNT, lines.size());
    }

}