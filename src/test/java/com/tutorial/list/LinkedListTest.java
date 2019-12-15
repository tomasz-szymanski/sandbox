package com.tutorial.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * Is implementation of Deque (double ended queue - spell. deck). add/removeFirst add/removeLast
 */
public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void shouldKeepElementsInOrderTheyWasAdded() {
        list.add(5);
        list.add(2);
        list.add(3);
        Assert.assertEquals("[5, 2, 3]", list.toString());
    }

    @Test
    public void shouldAddElementAtStart() {
        list.add(5);
        list.add(2);
        list.add(3);
        list.addFirst(6);

        Assert.assertEquals("[6, 5, 2, 3]", list.toString());
    }

    @Test
    public void shouldAddElementAtTheEnd() {
        list.add(5);
        list.add(2);
        list.add(3);
        list.addLast(19);

        Assert.assertEquals("[5, 2, 3, 19]", list.toString());
    }

    @Test
    public void shouldNotThrowWhenPollFromEmptyList() {
        list.poll();
        Assert.assertTrue(list.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowWhenRemoveFromEmptyLinkedList() {
        list.remove();
        Assert.assertNotNull(list);
    }

    @Test
    public void shouldRemoveAndReturnFirstElement() {
        list.add(3);
        list.add(6);
        Integer pop = list.pop();
        Assert.assertEquals(Integer.valueOf(3), pop);
        Assert.assertEquals(1, list.size());
    }
}
