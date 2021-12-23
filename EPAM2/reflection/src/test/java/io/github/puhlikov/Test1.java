package com.epam.training;

import com.epam.training.part1.factories.ProxyFactory;
import com.epam.training.part1.impl.PlantOne;
import com.epam.training.part1.impl.PlantTwo;
import com.epam.training.part1.interfaces.Plants;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.assertEquals;

public class Test1 {

    @Test
    public void testWorkPlants() {
        PlantOne plantOne = new PlantOne();
        int totalMaterial;
        totalMaterial = plantOne.processedMaterial(plantOne.receivedMaterial(12, 2), 6);

        assertEquals(8, totalMaterial);


        PlantTwo plantTwo = new PlantTwo();
        int totalMaterial1;
        totalMaterial1 = plantTwo.processedMaterial(plantTwo.receivedMaterial(10, 6), 6);

        Assert.assertEquals(10, totalMaterial1);
    }

    @Test
    public void testAnnotationProxy() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Plants plantOne = (Plants) ProxyFactory.getInstanceOf(PlantOne.class);
        Plants plantTwo = (Plants) ProxyFactory.getInstanceOf(PlantTwo.class);

        assertEquals(15, plantOne.receivedMaterial(10, 5));

        assertEquals(13, plantTwo.receivedMaterial(10, 3));
    }

}
