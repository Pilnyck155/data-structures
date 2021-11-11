package com.pilnyck.datastructure.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    public List list;

    @BeforeEach
    protected void before(){
        list = getList();
    }

    protected abstract List getList();

    @DisplayName("test add value to the end of list")
    @Test
    public void testIsAddValueToTheEnd(){

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        assertEquals(5, list.size());
        assertEquals("A",   list.get(0));
    }

    @DisplayName("test add value to the head of list")
    @Test
    public void testIsAddValueToHead(){

        list.add("A");
        list.add("B", 0);

        assertEquals("B", list.get(0));
    }

    @DisplayName("test add value by the index")
    @Test
    public void testIsAddValueByIndex(){

        list.add("A");
        list.add("C");
        list.add("D");
        System.out.println(list.toString());

        list.add("B", 1);
        System.out.println(list.toString());

        assertEquals("B", list.get(1));
    }

    @DisplayName("test add value by the index more then size and throw exception")
    @Test
    public void testIsAddValueByIndexMoreThenSizeAndThrowException(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertThrows(IllegalStateException.class, () -> {
            list.add("D", 50);
        });
    }

    @DisplayName("test add value by the index less the zero and throw exception")
    @Test
    public void testIsAddValueByIndexLessThenZeroAndThrowException(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertThrows(IllegalStateException.class, () -> {
            list.add("D", -32_000);
        });
    }

    @DisplayName("test remove value by index")
    @Test
    public void testRemoveWorkCorrectly(){

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        list.remove(2);
        assertEquals(3, list.size());
        assertEquals("D", list.get(2));
    }

    @DisplayName("test get value from end")
    @Test
    public void testGetWorkCorrectlyFromEnd(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.get(list.size()-1));
    }

    @DisplayName("test get value by index")
    @Test
    public void testGetWorkCorrectlyByIndex(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.get(1));
    }

    @DisplayName("test get value by index out of area of list and throw exception")
    @Test
    public void testGetWorkCorrectlyWhenIndexOutOfArea(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertThrows(IndexOutOfBoundsException.class, () ->{
            list.get(-50);
        });
    }

    @DisplayName("test set value by index")
    @Test
    public void testSetWorkCorrectly(){

        list.add("A");
        list.add("B");
        list.add("C");

        list.set("D", 2);
        assertEquals("D", list.get(2));
    }


    @DisplayName("test set value to head")
    @Test
    public void testSetToHeadWorkCorrectly(){

        list.add("A");
        list.add("B");
        list.add("C");

        list.set("W", 0);
        assertEquals("W", list.get(0));
    }

    @DisplayName("test clear list")
    @Test
    public void testClearWorkCorrectly(){

        list.add("A");
        list.add("B");

        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @DisplayName("test clear on empty list")
    @Test
    public void testClearOnEmptyListWorkCorrectly(){

        assertEquals(0, list.size());

        list.clear();

    }

    @DisplayName("test size the list")
    @Test
    public void testSizeWorkCorrectly(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
    }

    @DisplayName("test size on empty list")
    @Test
    public void testSizeOnEmptyWorkCorrectly(){


        assertEquals(0, list.size());
    }

    @DisplayName("test return true on empty list")
    @Test
    public void testReturnTrueWhenListIsEmpty(){


        assertTrue(list.isEmpty());
    }

    @DisplayName("test return false on empty list")
    @Test
    public void testReturnFalseWhetListIsNotEmpty(){

        list.add("A");

        assertFalse(list.isEmpty());
    }

    @DisplayName("test contain value in list")
    @Test
    public void testContainsWorkCorrectly(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.contains("B"));
    }


    @DisplayName("test contain value in list not found")
    @Test
    public void testContainsWorkCorrectlyWhenValueIsNotFound(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertFalse(list.contains("D"));
    }

    @DisplayName("test indexOf find first index by value")
    @Test
    public void testIndexOfWorkCorrect(){

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        list.add("C");

        assertEquals(2, list.indexOf("C"));
    }

    @DisplayName("test indexOf don't find index by value")
    @Test
    public void testIndexOfWorkCorrectWhenValueNotFound(){

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(-1, list.indexOf("D"));
    }

    @DisplayName("test last indexOf find last index by value")
    @Test
    public void testLastIndexOfWorkCorrect(){

        list.add("A");
        list.add("C");
        list.add("B");
        list.add("C");
        list.add("A");

        assertEquals(3, list.lastIndexOf("C"));
    }

    @DisplayName("test last indexOf don't find index by value and throw exception")
    @Test
    public void testLastIndexOfWorkCorrectWhenValueNotFound(){

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");

        assertEquals(-1, list.lastIndexOf("D"));
    }

    @DisplayName("test toString method work correctly")
    @Test
    public void testToStringMethod(){

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        String actual = list.toString();
        String expected = "[A,B,C,D]";

        assertEquals(expected, actual);
    }
    @DisplayName("test toString method work correctly with null value")
    @Test
    public void testToStringMethodWithNullValue(){
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(null);
        list.add("D");

        System.out.println(list.toString());
    }


    @DisplayName("test list iterator work correctly")
    @Test
    public void testIterator(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
        //System.out.println(list.toString());
    }
}
