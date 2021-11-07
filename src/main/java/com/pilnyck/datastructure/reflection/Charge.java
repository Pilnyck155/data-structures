package com.pilnyck.datastructure.reflection;

import com.pilnyck.datastructure.list.List;

public class Charge extends Bring implements List {

    @Override
    public void add(Object value) {

    }

    @Override
    public void add(Object value, int index) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    private void someTestVoidMethod() {
    }

    protected String someProtectedStringMethod() {
        return "";
    }

    public final int exampleMethod() {
        return -1;
    }

    private int exampleMethod2() {
        return -1;
    }

    protected final String someProtectedStringMethod(String str) {
        return someStringField;
    }

}
