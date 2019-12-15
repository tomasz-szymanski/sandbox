package com.tutorial.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TreeSetTest {

    private TreeSet<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new TreeSet<>();
    }

    @Test
    public void shouldSortByAddingToTreeSet() {
        tree.add(5);
        tree.add(3);
        tree.add(9);
        Assert.assertEquals("[3, 5, 9]", tree.toString());
    }

    @Test
    public void shouldReturnLowerWhenCallingFloor() {
        tree.add(5);
        tree.add(3);
        tree.add(9);
        Assert.assertEquals(Integer.valueOf(3), tree.floor(4));
    }

    @Test
    public void shouldReturnHigherWhenCallingFloor() {
        tree.add(5);
        tree.add(3);
        tree.add(9);
        Assert.assertEquals(Integer.valueOf(5), tree.ceiling(4));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenAddingNull() {
        tree.add(5);
        tree.add(null);
    }

    @Test
    public void shouldReturnLastElement() {
        tree.add(5);
        tree.add(3);
        tree.add(2);
        Assert.assertEquals(Integer.valueOf(5), tree.last());
    }

}
