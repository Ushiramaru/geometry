package com.epam.repository.impl;

import com.epam.entity.PyramidIdentifiable;
import com.epam.repository.Repository;
import com.epam.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PyramidIdentifiableRepository implements Repository<PyramidIdentifiable> {

    private List<PyramidIdentifiable> pyramids = new ArrayList<>();

    @Override
    public void addObject(PyramidIdentifiable object) {
        pyramids.add(object);
    }

    @Override
    public boolean removeObject(PyramidIdentifiable object) {
        return pyramids.remove(object);
    }

    @Override
    public boolean updateObject(PyramidIdentifiable object) {
        boolean isRemove = false;
        for (PyramidIdentifiable pyramid : pyramids) {
            if (pyramid.getId() == object.getId()) {
                isRemove = pyramids.remove(pyramid);
                break;
            }
        }
        if (isRemove) {
            addObject(object);
        }

        return isRemove;
    }

    @Override
    public List<PyramidIdentifiable> query(Specification<PyramidIdentifiable> specification) {
        List<PyramidIdentifiable> result = new ArrayList<>();
        for (PyramidIdentifiable pyramid : pyramids) {
            if (specification.specified(pyramid)) {
                result.add(pyramid);
            }
        }

        return result;
    }

    @Override
    public void sort(Comparator<PyramidIdentifiable> comparator) {
        pyramids.sort(comparator);
    }

}