package com.epam.repository.comparator;

import com.epam.entity.PyramidIdentifiable;

import java.util.Comparator;

public class ComparatorByIdIncrease implements Comparator<PyramidIdentifiable> {

    @Override
    public int compare(PyramidIdentifiable o1, PyramidIdentifiable o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }

}