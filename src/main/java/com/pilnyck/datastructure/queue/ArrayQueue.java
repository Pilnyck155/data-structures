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

        Object[] newArray = new Object[array.length-1];
        int index = 0;
        for (int i = 1; i < array.length-1; i++) {
            newArray[index] = array[i];
            index++;
        }
        Object dequeueValue = array[0];
        size--;
        array = newArray;
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
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    public String toString(){
        String queueArray ="[";
        int count = 1;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != null){
                queueArray += array[i];
                if(count != size){
                    queueArray += ", ";
                    count++;
                }
            }
        }
        queueArray +="]";
        return queueArray;
    }
}
