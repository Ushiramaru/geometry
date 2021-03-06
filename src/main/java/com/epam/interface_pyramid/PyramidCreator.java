package com.epam.interface_pyramid;

import com.epam.entity.Pyramid;

import java.util.Optional;

public interface PyramidCreator {

    Optional<Pyramid> create(String line);

}