package com.pilnyck.datastructure.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeueWorkCorrectAndChangeSize(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        arrayQueue.isEmpty();
    }

    @Test
    public void testPeek(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");

        assertEquals(4, arrayQueue.size());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals(4, arrayQueue.size());
        arrayQueue.toString();
    }


    @Test
    public void testIsEmptyReturnTrueOnNewQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");

        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClean(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.clear();

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertTrue(arrayQueue.contains("A"));
    }

    @Test
    public void testContainsReturnFalse(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertFalse(arrayQueue.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        assertFalse(arrayQueue.contains("C"));
    }

    @Test
    public void testThrowIllegalStateExceptionWithQueueIsEmpty(){
        ArrayQueue arrayQueue = new ArrayQueue();
        assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }
}
