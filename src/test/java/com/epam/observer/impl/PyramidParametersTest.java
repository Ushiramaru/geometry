package com.epam.observer.impl;

import com.epam.PyramidCalculator;
import com.epam.entity.Point;
import com.epam.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class PyramidParametersTest {

    private final static Point TOP = new Point(1, 1, 1);
    private final static Triangle BASE = new Triangle(new Point(1, 2, 3),
            new Point(2, 2, 2), new Point(5, 2, 8));
    private final static PyramidObservable OBSERVABLE = new PyramidObservable(TOP, BASE, 1);

    @Test
    public void updateTestShouldByUpdateAfterChange() {
        PyramidParameters parameters = new PyramidParameters(new PyramidCalculator());
        OBSERVABLE.addObserver(parameters);
        double volume = parameters.getVolume();
        OBSERVABLE.setTop(new Point(2, 10, 2));
        double otherVolume = parameters.getVolume();
        Assert.assertNotEquals(volume, otherVolume);
    }

}