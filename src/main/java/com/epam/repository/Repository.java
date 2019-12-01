package com.epam.repository;

import com.epam.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void addObject(T object);

    boolean removeObject(T object);

    boolean updateObject(T object);

    List<T> query(Specification<T> specification);

    void sort(Comparator<T> comparator);

}