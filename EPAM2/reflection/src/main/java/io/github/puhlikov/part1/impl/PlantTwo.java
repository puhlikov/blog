package com.epam.training.part1.impl;

import com.epam.training.part1.interfaces.Plants;

import java.util.logging.Logger;

public class PlantTwo implements Plants {

    private static final Logger LOGGER = Logger.getLogger(PlantTwo.class.getName());

    public int receivedMaterial(int StoredOfMaterial, int quantity) {
        LOGGER.info(String.format("Plant Two received: " + quantity));
        return StoredOfMaterial + quantity;
    }

    public int processedMaterial(int StoredOfMaterial, int quantity) {
        LOGGER.info(String.format("Plant Two processed: " + quantity));
        return StoredOfMaterial - quantity;
    }
}
