package com.epam.training;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class LFUCacheTest {
    private LFUCache<String, Integer> actualLFU;
    private LFUCache<String, Integer> expectedLFU;
    private int VOLUME = 3;

    @Before
    public void createMap() {
        actualLFU = new LFUCache<>(VOLUME);
        actualLFU.put("1");
        actualLFU.put("2");
        actualLFU.put("3");
    }


    @Test
    public void isLFUCacheCreate() {
        Cache<String, Integer> cache = new LFUCache<>(0);
        assertNotNull(cache);
    }

    @Test
    public void isCheckCounter() {
        Integer actual = actualLFU.put("5");
        Integer expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void isCheckCounterAfterPut() {
        actualLFU.put("1");
        Integer actual = actualLFU.get("1");
        Integer expected = 1;
        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void putNewValueInLFUCache() {
        actualLFU = new LFUCache<>(0);
        actualLFU.put("1");
    }

    @Test
    public void isGetValueFromLFUCache() {
        actualLFU = new LFUCache<>(VOLUME);
        actualLFU.put("1");
        Integer actual = actualLFU.get("1");
        Integer expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void isGetAllValuesFromLFUCache() {
        String[] actual = actualLFU.getAll();
        String[] expected = {"1", "2", "3"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void isCacheEquals() {
        Cache<String, Integer> actual = new LRUCache<>(VOLUME);
        Cache<String, Integer> expected = new LRUCache<>(VOLUME);
        assertEquals(expected, actual);
    }

    @Test
    public void isNoFullMapsEquals() {
        Cache<String, Integer> expected = new LRUCache<>(VOLUME);
        expected.put("1");
        Cache<String, Integer> actual = new LRUCache<>(VOLUME);
        actual.put("1");
        assertEquals(expected, actual);
    }


    @Test(expected = NullPointerException.class)
    public void isRemove() {
        actualLFU = new LFUCache<>(VOLUME);
        actualLFU.put("1");
        actualLFU.remove("1");
        actualLFU.get("1");
    }

    @Test
    public void isMapsEqualsAfterRemove() {
        Cache<String, Integer> actual = new LFUCache<>(VOLUME);
        actual.put("1");
        actual.remove("1");
        Cache<Integer, Integer> expected = new LFUCache<>(VOLUME);
        assertEquals(expected, actual);
    }

}
