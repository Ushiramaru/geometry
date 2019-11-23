package com.epam.implPyramid;

import com.epam.interfacePyramid.FileLineReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class PrimitiveFileLineReaderTest {

    private final static FileLineReader READER = new PrimitiveFileLineReader();
    private static List<String> lines;
    private final static int EXPECTED_LINES_COUNT = 3;
    private final static String path = "\\geometry\\src\\test\\resources\\pyramids.txt";

    @BeforeClass
    public static void setUp() {
        lines = READER.readLines(path);
    }

    @Test
    public void readLinesShould3Lines() {
        Assert.assertEquals(EXPECTED_LINES_COUNT, lines.size());
    }

}