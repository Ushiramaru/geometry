package com.epam.repository.specification.impl;

import com.epam.entity.PyramidIdentifiable;
import com.epam.repository.specification.Specification;

public class SpecificationPyramidByNothing implements Specification<PyramidIdentifiable> {

    @Override
    public boolean specified(PyramidIdentifiable object) {
        return true;
    }

}