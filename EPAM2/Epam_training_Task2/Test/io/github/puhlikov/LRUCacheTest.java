package com.epam.training;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    private LRUCache<String, Integer> actualLRU;
    private LRUCache<String, Integer> expectedLRU;
    private int VOLUME = 3;

    @Before
    public void createMap() {
        actualLRU = new LRUCache<>(VOLUME);
        actualLRU.put("1");
        actualLRU.put("2");
        actualLRU.put("3");
    }

    @Test
    public void isLRUCacheCreate() {
        Cache<String, Integer> cache = new LRUCache<>(0);
        assertNotNull(cache);

    }

    @Test
    public void isPutValueLRUCache() {
        actualLRU = new LRUCache<>(0);
        actualLRU.put("1");
        assertNotNull(actualLRU);
    }

    @Test
    public void isPutNextValueLRUCache(){
        assertNull(actualLRU.put("2"));
    }


    @Test
    public void isNonEmptyLRUCacheEquals() {
        actualLRU = new LRUCache<>(VOLUME);
        actualLRU.put("1");
        expectedLRU = new LRUCache<>(VOLUME);
        expectedLRU.put("1");
        assertEquals(expectedLRU, actualLRU);
    }

    @Test
    public void isGetValueFromLRUCache() {
        actualLRU = new LRUCache<>(VOLUME);
        actualLRU.put("1");
        assertNull(actualLRU.get("1"));
    }

    @Test
    public void isGetValueEmptyLRUCache(){
        actualLRU = new LRUCache<>(VOLUME);
        assertNull(actualLRU.get("1"));
    }


    @Test
    public void isGetAllFromLRUCache() {
        String[] actual = actualLRU.getAll();
        String[] expected = {"1", "2", "3"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void isRemoveFromLRUCache() {
        actualLRU = new LRUCache<>(VOLUME);
        actualLRU.put("1");
        actualLRU.remove("1");
        expectedLRU = new LRUCache(VOLUME);
        assertEquals(expectedLRU, actualLRU);
    }

    @Test
    public void isEqualsMaps() {
        actualLRU = new LRUCache<>(VOLUME);
        expectedLRU = new LRUCache<>(VOLUME);
        assertEquals(expectedLRU, actualLRU);
    }

}
