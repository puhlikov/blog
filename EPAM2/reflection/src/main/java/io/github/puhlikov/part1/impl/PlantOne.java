package com.epam.training.part1.impl;

import com.epam.training.part1.annotations.Proxy;
import com.epam.training.part1.handler.PlantHandler;
import com.epam.training.part1.interfaces.Plants;

import java.util.logging.Logger;

@Proxy(invocationHandler = PlantHandler.class)

public class PlantOne implements Plants {

    private static final Logger LOGGER = Logger.getLogger(PlantOne.class.getName());

    public int receivedMaterial(int StoredOfMaterial, int quantity) {
        LOGGER.info(String.format("Plant One received: " + quantity));
        return StoredOfMaterial + quantity;
    }

    public int processedMaterial(int StoredOfMaterial, int quantity) {
        LOGGER.info(String.format("Plant One processed: " + quantity));
        return StoredOfMaterial - quantity;
    }
}
