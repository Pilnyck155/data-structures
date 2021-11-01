package com.pilnyck.datastructure.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {


    @DisplayName("test add value to the end of array")
    @Test
    public void testIsAddValueToTheEndOfArray(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        assertEquals("C",   arrayList.get(arrayList.size()-1));
    }

    @DisplayName("test add value to array by the index")
    @Test
    public void testIsAddValueByIndex(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.add("D", 1);
        assertEquals("B", arrayList.get(2));
    }

    @DisplayName("test add value to array by the index more then size and throw exception")
    @Test
    public void testIsAddValueByIndexMoreThenSizeAndThrowException(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("D", 5);
        });
    }


    @DisplayName("test add value to array by the index more then size and throw exception")
    @Test
    public void testIsAddValueByIndexLessThenZeroAndThrowException(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("D", -1);
        });
    }

    @DisplayName("test remove value by index")
    @Test
    public void testRemoveWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        arrayList.remove(0);
        assertEquals(1, arrayList.size());
        assertEquals("B", arrayList.get(0));
    }

    @DisplayName("test get value by index")
    @Test
    public void testGetWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("C", arrayList.get(arrayList.size()-1));
    }

    @DisplayName("test get value by index out of area of list and throw exception")
    @Test
    public void testGetWorkCorrectlyWhenIndexOutOfArea(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertThrows(IndexOutOfBoundsException.class, () ->{
            arrayList.get(-5);
        });
    }

    @DisplayName("test set value by index")
    @Test
    public void testSetWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.set("D", 2);
        assertEquals("D", arrayList.get(2));
    }

    @DisplayName("test clear array")
    @Test
    public void testClearWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertEquals(2, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @DisplayName("test size the list")
    @Test
    public void testSizeWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
    }

    @DisplayName("test return true on empty list")
    @Test
    public void testReturnTrueWhenListIsEmpty(){
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("test return false on empty list")
    @Test
    public void testReturnFalseWhetListIsNotEmpty(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        assertFalse(arrayList.isEmpty());
    }

    @DisplayName("test contain value in list")
    @Test
    public void testContainsWorkCorrectly(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertTrue(arrayList.contains("B"));
    }


    @DisplayName("test contain value in list not found")
    @Test
    public void testContainsWorkCorrectlyWhenValueIsNotFound(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertFalse(arrayList.contains("D"));
    }

    @DisplayName("test indexOf find first index by value")
    @Test
    public void testIndexOfWorkCorrect(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertEquals(1, arrayList.indexOf("B"));
    }

    @DisplayName("test indexOf don't find index by value")
    @Test
    public void testIndexOfWorkCorrectWhenValueNotFound(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(-1, arrayList.indexOf("D"));
    }

    @DisplayName("test last indexOf find last index by value")
    @Test
    public void testLastIndexOfWorkCorrect(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertEquals(3, arrayList.lastIndexOf("A"));
    }

    @DisplayName("test last indexOf don't find index by value and throw exception")
    @Test
    public void testLastIndexOfWorkCorrectWhenValueNotFound(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertEquals(-1, arrayList.lastIndexOf("D"));
    }

    @DisplayName("test last indexOf don't find index by value and throw exception")
    @Test
    public void testEnsureCapacityCorrectWork(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("H");
        arrayList.add("I");
        arrayList.add("J");
        arrayList.add("K");
        arrayList.add("L");

        assertEquals(12, arrayList.size());
    }
}
