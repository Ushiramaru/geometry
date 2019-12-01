package com.epam.observer.impl;

import com.epam.PyramidCalculator;
import com.epam.observer.Observer;

public class PyramidParameters implements Observer<PyramidObservable> {

    private PyramidCalculator calculator;
    private double surfaceArea;
    private double volume;

    public PyramidParameters(PyramidCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void update(PyramidObservable pyramidObservable) {
        surfaceArea = calculator.surfaceArea(pyramidObservable);
        volume = calculator.volume(pyramidObservable);
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public PyramidCalculator getCalculator() {
        return calculator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PyramidParameters that = (PyramidParameters) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 &&
                Double.compare(that.volume, volume) == 0 &&
                calculator.equals(that.calculator);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * (31 + Double.hashCode(surfaceArea)) + Double.hashCode(volume)) + calculator.hashCode();
    }

}