package com.epam.interface_pyramid;

import com.epam.entity.Triangle;

import java.util.Optional;

public interface TriangleCreator {

    Optional<Triangle> create(String line);

}