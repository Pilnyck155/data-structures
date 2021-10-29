package com.pilnyck.datastructure.queue;

public class ArrayQueue implements Queue{
    int size;
    Object[] array;

    public ArrayQueue(){
        array = new Object[10];
    }
//    public ArrayQueue(int initialSize){
//        array = new Object[initialSize];
//    }

    @Override
    public void enqueue(Object value) {
        if (value == null){
            throw new IllegalArgumentException("Null are not supported!");
        }
        array[size] = value;
        size++;
    }

    //[0, 1, 2]
    //[A, B, C] ->
    @Override
    public Object dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        Object dequeueValue = array[0];
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }

        size--;
        return dequeueValue;
    }

    @Override
    public Object peek() {
        Object currentObject = array[0];
        return currentObject;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null){
            throw new IllegalArgumentException("Null are not supported!");
        }
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size-1; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int count = 1;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != null){
                builder.append(array[i]);
                if(count != size){
                    builder.append(", ");
                    count++;
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }
}