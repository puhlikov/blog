package com.epam.training.part2.bean;

import com.epam.training.part2.annotations.Equal;
import com.epam.training.part2.enums.Compare;

import java.util.stream.Collectors;

public class WoodMaterial extends Material {

    @Equal (compareBy = Compare.VALUE)
    private int sampleNumber;

    public WoodMaterial(String name, String viewMaterial, int quantity, int sampleNumber) {
        super(name, viewMaterial, quantity);

        this.sampleNumber = sampleNumber;

    }
}
