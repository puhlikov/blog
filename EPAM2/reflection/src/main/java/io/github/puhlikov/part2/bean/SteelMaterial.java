package com.epam.training.part2.bean;

public class SteelMaterial extends Material{


    private int timeOfProcessing;

    public SteelMaterial(String name, String viewMaterial, int quantity, int timeOfProcessing) {
        super(name, viewMaterial, quantity);
        this.timeOfProcessing = timeOfProcessing;
    }

}
