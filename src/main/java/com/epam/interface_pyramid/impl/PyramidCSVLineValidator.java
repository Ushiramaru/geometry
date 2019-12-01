package com.epam.interface_pyramid.impl;

import com.epam.interface_pyramid.PyramidLineValidator;

public class PyramidCSVLineValidator implements PyramidLineValidator {

    private final static String REGEX = "(-?(\\d)+;){12}";

    @Override
    public boolean isValid(String line) {
        return line.matches(REGEX);
    }

}