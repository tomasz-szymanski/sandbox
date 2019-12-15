package com.tutorial.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {

    private static final float LOAD_FACTOR = 0.75f;

    @Test
    public void shouldReplaceElementWhenUseSameKey() {
        HashMap<Integer, Object> hashMap = new HashMap<>(10, LOAD_FACTOR);
        hashMap.put(1, new Object());
        hashMap.put(1, new Object());

        Assert.assertEquals(1, hashMap.size());
    }

}
