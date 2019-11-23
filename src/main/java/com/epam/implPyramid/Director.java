package com.epam.implPyramid;

import com.epam.entity.Pyramid;
import com.epam.interfacePyramid.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public final class Director implements PyramidExtractor {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Director.class));

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
        LOGGER.info("Start extract");
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
                    LOGGER.info("Find satisfying object");
                    pyramids.add(optionalPyramid.get());
                }
            }
        }
        LOGGER.info("End extract");

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
