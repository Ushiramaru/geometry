package com.epam.repository.specification.impl;

import com.epam.PyramidCalculator;
import com.epam.entity.PyramidIdentifiable;
import com.epam.repository.specification.Specification;

public class SpecificationPyramidByVolumeRange implements Specification<PyramidIdentifiable> {

    private int minVolume;
    private int maxVolume;
    private PyramidCalculator calculator;

    public SpecificationPyramidByVolumeRange(int minVolume, int maxVolume, PyramidCalculator calculator) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(PyramidIdentifiable object) {
        double volume = calculator.volume(object);
        return Double.compare(volume, minVolume) >= 0 && Double.compare(volume, maxVolume) <= 0;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public PyramidCalculator getCalculator() {
        return calculator;
    }

}