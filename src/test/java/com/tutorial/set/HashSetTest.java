package com.tutorial.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

class Element {
    private Integer id;

    public Element(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(id, element.id);
    }

    @Override
    public int hashCode() {
        if (this.id < 5) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                '}';
    }
}

public class HashSetTest {

    private static final float LOAD_FACTOR = 0.75f;
    private HashSet<Element> set;
    private HashSet<Integer> intSet;


    @Before
    public void setUp() throws Exception {
        set = new HashSet<>(10, LOAD_FACTOR);
        intSet = new HashSet<>();
    }

    @Test
    public void shouldPutTwoElementsInFirstBucketAndTwoInNext() {
        set.add(new Element(2));
        set.add(new Element(7));
        set.add(new Element(6));
        set.add(new Element(4));

        Assert.assertEquals("[Element{id=2}, Element{id=4}, Element{id=7}, Element{id=6}]", set.toString());

    }

    @Test
    public void shouldAllowNullValues() {
        set.add(new Element(1));
        set.add(null);

        Assert.assertEquals(2, set.size());

    }
}
