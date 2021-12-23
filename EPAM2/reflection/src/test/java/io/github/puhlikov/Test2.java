package com.epam.training;

import com.epam.training.part2.analyzer.FieldAnalyzer;
import com.epam.training.part2.bean.SteelMaterial;
import com.epam.training.part2.bean.WoodMaterial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Test2 {
    private WoodMaterial woodMaterial1;
    private WoodMaterial woodMaterial2;
    private WoodMaterial woodMaterial3;
    private SteelMaterial steelMaterial1;

    private FieldAnalyzer fieldAnalyzer;

    @Before
    public void setUp() {
        woodMaterial1 = new WoodMaterial("Oak", "Wood material - balk", 5, 1);
        woodMaterial2 = new WoodMaterial("Oak", "Wood material - balk", 5, 1);
        woodMaterial3 = new WoodMaterial("birch tree", "Wood material - board", 10, 56);
        steelMaterial1 = new SteelMaterial("Steel", "Steel work piece", 5, 25);
        fieldAnalyzer = new FieldAnalyzer();
    }

    @Test
    public void testAnalyzer() throws IllegalAccessException {
        Assert.assertTrue(fieldAnalyzer.equalObject(woodMaterial1, woodMaterial2));
        Assert.assertFalse(fieldAnalyzer.equalObject(woodMaterial1, woodMaterial3));
        Assert.assertFalse(fieldAnalyzer.equalObject(woodMaterial1, steelMaterial1));
    }
}
