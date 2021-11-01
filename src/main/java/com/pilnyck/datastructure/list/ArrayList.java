package com.pilnyck.datastructure.list;

import java.util.StringJoiner;

public class ArrayList implements List{
    private int size = 0;
    Object[] arrayList;

    ArrayList(){
        arrayList = new Object[10];
    }

    @Override
    public void add(Object value) {
        //increaseSize();
        //arrayList[size] = value;
        //size++;
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        increaseSize();

        for (int i = size; i > index; i--) {
            arrayList[i] = arrayList[i-1];
        }
        arrayList[size] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size()-1){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (i == index){
                arrayList[i] = arrayList[i+1];
                arrayList[i+1] = null;
            }
        }
        return arrayList;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size()-1){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        return arrayList[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index > size()-1){
            throw new IndexOutOfBoundsException("Index out of area of list");
        }
        for (int i = 0; i < size(); i++) {
            if (i == index){
                arrayList[i] = value;
                break;
            }
        }
        return arrayList;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            arrayList[i] = null;
        }
    }

    @Override
    public int size() {
        for (int i = 0; i < arrayList.length-1; i++) {
            if (arrayList[i] == null){
                size = i;
                break;
            }
        }
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
        for (Object o : arrayList) {
            if (o == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = arrayList.length-1; i > 0; i--) {
            if (arrayList[i] == value){
                return i;
            }
        }
        return -1;
    }

    private void increaseSize(){
        if (arrayList.length == size){
            Object[] newArrayList = new Object[(arrayList.length * 3)/2];
            for (int i = 0; i < arrayList.length; i++) {
                newArrayList[i] = arrayList[i];
            }
            arrayList = newArrayList;
        }
    }

    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", " , "[", "]");
        for (int i = 0; i <size(); i++) {
            stringJoiner.add(arrayList[i].toString());
        }
        return stringJoiner.toString();
    }
}