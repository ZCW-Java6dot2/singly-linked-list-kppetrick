package com.zipcodewilmington.singlylinkedlist;

public class Node<SomeType> {

    private SomeType data;
    private Node next;
    private int index = 0;

    public Node(SomeType data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(SomeType data) {
        this.data = data;
    }

    public SomeType getData() {
        return data;
    }

    public void setData(SomeType data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

