package com.pilnyck.datastructure.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList implements List, Iterable{

    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index > size || index < 0){
            throw new IllegalStateException("Index don't correct");
        }
        Node newNode = new Node(value);
        if (size == 0){
            head = tail = newNode;
        } else if (index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }else if (index == 0){
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node currentNode = getNode(index);
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
            }
        size++;
        }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        Node currentNode = getNode(index);
        currentNode = currentNode.next;
        currentNode.prev = currentNode;
        size--;
        return currentNode;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        Node currentNode = getNode(index);
        return currentNode.value;
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        Node currentNode = getNode(index);
        currentNode.value = value;
        return currentNode;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        Node currentNode = head;
        for (int i = 0; i < size-1; i++) {
            if (currentNode.value == value){
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node currentNode = tail;
        for (int i = size-1; i > 0; i--) {
            if (currentNode.value == value){
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index == 0) { // start from head
            Node currentNode = head;
            return currentNode;
        } else if (index <= size / 2) { // start from head
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }else { // start from tail
            Node currentNode = tail;
            for (int i = size-1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            return currentNode;
        }
    }

    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node currentNode = head;
        for (Object obj: this) {
            try{
                stringJoiner.add(obj.toString());
                currentNode = currentNode.next;
            }catch (NullPointerException exception){
                stringJoiner.add(null);
                currentNode = currentNode.next;
            }
        }
        return stringJoiner.toString();
    }


    @Override
    public Iterator iterator() {
        return new LinkedIterator();
    }
    private class LinkedIterator implements Iterator{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Node currentNode = getNode(index);
            Object value = currentNode.value;
            index++;
            return value;
        }
    }
}
