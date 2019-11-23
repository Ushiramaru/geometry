package com.epam.implPyramid;

import com.epam.interfacePyramid.PyramidLineValidator;

public final class PyramidCSVLineValidator implements PyramidLineValidator {

    private final static String regex = "(-?(\\d)+;){12}";

    @Override
    public boolean isValid(String line) {
        return line.matches(regex);
    }

}
