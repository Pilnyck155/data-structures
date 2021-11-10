package com.pilnyck.datastructure.list;

 class Node {
    Node next;
    Node prev;
    Object value;

    protected Node(Object value){
        this.value = value;
    }
}
