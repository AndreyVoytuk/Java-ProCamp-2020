package com.sagax.javaprocamp2020.task1;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomArrayListTest {

    private List<String> list;

    @Before
    public void setUp(){
        list = new CustomArrayList<>();
    }

    @Test
    public void testListInit(){
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddElements() {
        list.add("Andrii");
        list.add("Serg");
        list.add("Alan");

        assertEquals("Andrii", list.get(0));
        assertEquals("Serg", list.get(1));
        assertEquals("Alan", list.get(2));

        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveElement(){
        list.add("Andrii");
        list.add("Serg");
        list.add("Alan");

        assertEquals("Alan", list.remove(2));
        assertEquals(2, list.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmptyList(){
        list.remove(0);
    }
}
