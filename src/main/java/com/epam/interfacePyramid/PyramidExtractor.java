package com.epam.interfacePyramid;

import com.epam.entity.Pyramid;

import java.util.List;

public interface PyramidExtractor {

    public List<Pyramid> extract(String path);
    
}
