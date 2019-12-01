package com.epam.repository.specification;

public interface Specification<T> {

    boolean specified(T object);

}