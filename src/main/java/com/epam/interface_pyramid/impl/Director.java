package com.epam.interface_pyramid.impl;

import com.epam.entity.Pyramid;
import com.epam.interface_pyramid.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

public final class Director implements PyramidExtractor {

    private static final Logger LOGGER = Logger.getLogger(Director.class);
    private static final String LOGGER_MESSAGE_START = "Start extract";
    private static final String LOGGER_MESSAGE_FIND = "Find satisfying object";
    private static final String LOGGER_MESSAGE_END = "End extract";

    private FileLineReader fileLineReader;
    private PyramidLineValidator pyramidLineValidator;
    private PyramidCreator pyramidCreator;
    private PyramidValidator pyramidValidator;

    public Director(FileLineReader fileLineReader, PyramidLineValidator pyramidLineValidator,
                    PyramidCreator pyramidCreator, PyramidValidator pyramidValidator) {
        this.fileLineReader = fileLineReader;
        this.pyramidLineValidator = pyramidLineValidator;
        this.pyramidCreator = pyramidCreator;
        this.pyramidValidator = pyramidValidator;
    }

    @Override
    public List<Pyramid> extract(String path) {
        LOGGER.info(LOGGER_MESSAGE_START);
        List<String> lines = fileLineReader.readLines(path);
        List<Optional<Pyramid>> optionalsPyramid = new ArrayList<>();
        for (String line : lines) {
            if (pyramidLineValidator.isValid(line)) {
                optionalsPyramid.add(pyramidCreator.create(line));
            }
        }

        List<Pyramid> pyramids = new ArrayList<>();
        for (Optional<Pyramid> optionalPyramid : optionalsPyramid) {
            if (optionalPyramid.isPresent()) {
                if (pyramidValidator.isValid(optionalPyramid.get())) {
                    LOGGER.info(LOGGER_MESSAGE_FIND);
                    pyramids.add(optionalPyramid.get());
                }
            }
        }
        LOGGER.info(LOGGER_MESSAGE_END);

        return pyramids;
    }

    public FileLineReader getFileLineReader() {
        return fileLineReader;
    }

    public PyramidLineValidator getPyramidLineValidator() {
        return pyramidLineValidator;
    }

    public PyramidCreator getPyramidCreator() {
        return pyramidCreator;
    }

    public PyramidValidator getPyramidValidator() {
        return pyramidValidator;
    }

}