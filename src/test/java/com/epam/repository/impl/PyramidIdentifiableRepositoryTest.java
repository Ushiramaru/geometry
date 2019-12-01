package com.epam.repository.impl;

import com.epam.entity.Point;
import com.epam.entity.PyramidIdentifiable;
import com.epam.entity.Triangle;
import com.epam.repository.Repository;
import com.epam.repository.specification.impl.SpecificationPyramidByIdRange;
import com.epam.repository.specification.impl.SpecificationPyramidByNothing;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PyramidIdentifiableRepositoryTest {

    private final static int EXPECTED_ADD_OBJECT_COUNT = 1;
    private final static int EXPECTED_REMOVE_OBJECT_COUNT = 1;
    private final static int EXPECTED_RETURN_OBJECT_COUNT = 1;
    private final static Point TOP = new Point(1, 1, 1);
    private final static Triangle BASE = new Triangle(new Point(1, 2, 3),
            new Point(2, 2, 2), new Point(5, 2, 8));
    private final static PyramidIdentifiable PYRAMID = new PyramidIdentifiable(TOP, BASE, 1);

    @Test
    public void addObjectTestShouldByAddOneObject() {
        Repository<PyramidIdentifiable> repository = new PyramidIdentifiableRepository();
        int firstCount = repository.query(new SpecificationPyramidByNothing()).size();
        repository.addObject(null);
        int lastCount = repository.query(new SpecificationPyramidByNothing()).size();
        Assert.assertEquals(EXPECTED_ADD_OBJECT_COUNT, lastCount - firstCount);
    }

    @Test
    public void removeObjectTestShouldByRemoveOneObject() {
        Repository<PyramidIdentifiable> repository = new PyramidIdentifiableRepository();
        repository.addObject(null);
        int firstCount = repository.query(new SpecificationPyramidByNothing()).size();
        repository.removeObject(null);
        int lastCount = repository.query(new SpecificationPyramidByNothing()).size();
        Assert.assertEquals(EXPECTED_REMOVE_OBJECT_COUNT, firstCount - lastCount);
    }

    @Test
    public void updateObjectTestShouldByUpdateObjectWhenRepositoryContainThisObject() {
        Repository<PyramidIdentifiable> repository = new PyramidIdentifiableRepository();
        PyramidIdentifiable pyramid = new PyramidIdentifiable(TOP, BASE, 1);
        repository.addObject(pyramid);
        pyramid.setTop(new Point(2, 3, 3));
        repository.updateObject(pyramid);
        PyramidIdentifiable newPyramid = repository.query(new SpecificationPyramidByIdRange(1)).get(0);
        Assert.assertEquals(pyramid, newPyramid);
    }

    @Test
    public void queryTestShouldByReturnOneObjectWhenSpecificationByIdInRangeTwoTwo() {
        Repository<PyramidIdentifiable> repository = new PyramidIdentifiableRepository();
        PyramidIdentifiable pyramid = new PyramidIdentifiable(TOP, BASE, 2);
        repository.addObject(PYRAMID);
        repository.addObject(pyramid);
        List<PyramidIdentifiable> pyramids = repository.query(new SpecificationPyramidByIdRange(2));
        Assert.assertEquals(EXPECTED_RETURN_OBJECT_COUNT, pyramids.size());
    }

}