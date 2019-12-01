package com.epam.repository.specification.impl;

import com.epam.entity.PyramidIdentifiable;
import com.epam.repository.specification.Specification;

public class SpecificationPyramidByIdRange implements Specification<PyramidIdentifiable> {

    private int minId;
    private int maxId;

    public SpecificationPyramidByIdRange(int id) {
        this(id, id);
    }

    public SpecificationPyramidByIdRange(int minId, int maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specified(PyramidIdentifiable object) {
        int id = object.getId();
        return id >= minId && id <= maxId;
    }

    public int getMinId() {
        return minId;
    }

    public int getMaxId() {
        return maxId;
    }

}