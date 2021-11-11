package com.pilnyck.datastructure.list;

import java.util.Arrays;
import java.util.Iterator;

public class Test {
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
