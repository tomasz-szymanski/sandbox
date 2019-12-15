package com.tutorial.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    private TreeMap<Integer, Object> map;

    @Before
    public void setUp() {
        map = new TreeMap<>();
    }

    @Test
    public void shouldSortElementsByKeysAndReturnFirstKey() {
        map.put(9, new Object());
        map.put(3, new Object());
        map.put(4, new Object());

        Assert.assertEquals(Integer.valueOf(3), map.firstKey());
    }

    @Test
    public void shouldSortElementsByKeysAndReturnLastKey() {
        map.put(9, new Object());
        map.put(3, new Object());
        map.put(4, new Object());

        Assert.assertEquals(Integer.valueOf(9), map.lastKey());
    }


}
