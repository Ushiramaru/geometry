package com.epam.interface_pyramid;

import com.epam.entity.Pyramid;

import java.util.List;

public interface PyramidExtractor {

    public List<Pyramid> extract(String path);
    
}