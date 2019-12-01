package com.epam.entity;

public class PyramidIdentifiable extends Pyramid {

    private int id;

    public PyramidIdentifiable(Point top, Triangle base, int id) {
        super(top, base);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PyramidIdentifiable that = (PyramidIdentifiable) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 31 * (31 + id) + super.hashCode();
    }

}