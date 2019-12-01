package com.epam;

import com.epam.observer.impl.PyramidParameters;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PyramidParametersStorage {

    private static PyramidParametersStorage instance;
    private Map<Integer, PyramidParameters> map;

    private PyramidParametersStorage() {
        map = new HashMap<>();
    }

    public static PyramidParametersStorage getInstance() {
        if (instance == null) {
            instance = new PyramidParametersStorage();
        }

        return instance;
    }

    public PyramidParameters addPyramidParameters(Integer pyramidId, PyramidParameters parameters) {
        return map.put(pyramidId, parameters);
    }

    public Optional<PyramidParameters> findPyramidParameters(Integer pyramidId) {
        Optional<PyramidParameters> optional;
        if (map.containsKey(pyramidId)) {
            optional = Optional.of(map.get(pyramidId));
        } else {
            optional = Optional.empty();
        }

        return optional;
    }

}