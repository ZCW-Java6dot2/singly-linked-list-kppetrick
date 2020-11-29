package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<SomeType extends Comparable<SomeType>> implements Comparable<Node<SomeType>>{
    private static int counter;
    private Node<SomeType> tail;
    private Node<SomeType> head;
    private int length;

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    public SinglyLinkedList() {
        tail = null;
        head = null;
        length = 0;
    }

    public int size() {
        return getCounter();
    }

    public SomeType get(int index) {
        int tempIndex = head.getIndex();
        Node<SomeType> tempNode = head;
        while (tempIndex != index) {
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        return tempNode.getData();
    }

    public void set(int index, SomeType data) {
        int tempIndex = head.getIndex();
        Node<SomeType> tempNode = head;
        while (tempIndex != index) {
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        tempNode.setData(data);
    }

    public void swap(SomeType data1, SomeType data2) {
        Node<SomeType> tempNode = head;
        int indexData1 = -1;
        int indexData2 = -1;
        while (tempNode != null) {
            if (tempNode.getData() == data1)
                indexData2 = tempNode.getIndex();
            else if (tempNode.getData() == data2)
                indexData1 = tempNode.getIndex();
            tempNode = tempNode.getNext();
        }
        this.set(indexData2, data1);
        this.set(indexData1, data2);
    }

    public void add(SomeType data) {
        if (head == null) {
            head = new Node(data);
        }
        Node temp = new Node(data);
        Node current = head;
        if (current != null) {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
        incrementCounter();
    }

    public void add(SomeType data, int index) {
        if (head == null) {
            head = new Node(data);
        }
        Node tempNode = new Node(data);
        Node currentNode = head;
        if (currentNode != null) {
            for (int i = 0; i < index && currentNode.getNext() != null; i++) {

                currentNode = currentNode.getNext();
            }
            tempNode.setNext(currentNode.getNext());
            currentNode.setNext(tempNode);
        }
        incrementCounter();
    }

    public void remove(int index) {
        Node currentNode;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i <= index; i++) {
                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        decrementCounter();
    }

    public Boolean contains(SomeType data) {
        Node currentNode;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i < size(); i++) {
                if (currentNode.getData().equals(data)) {

                    return true;
                }
                currentNode = currentNode.getNext();
            }

        }
        return false;
    }

    public int find(SomeType data) {
        Node currentNode;
        if (head != null) {
            currentNode = head;
            for (int i = 0; i < size(); i++) {
                if (currentNode.getData().equals(data)) {

                    return i;
                }
                currentNode = currentNode.getNext();
            }

        }
        return -1;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList copy = new SinglyLinkedList();
        SomeType tempNode = null;
        Node currentNode = head.getNext();
        if (currentNode != null) {
            while (currentNode.getNext() != null) {
                tempNode = (SomeType) currentNode.getData();
                copy.add(tempNode);
                currentNode = currentNode.getNext();
            }
            copy.add(currentNode.getData());
        }
        return copy;
    }

    public void sort(SinglyLinkedList passedList) {
        int size = passedList.size();
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                Node currentNode = head;
                Node next = head.getNext();
                for (int j = 0; j < size - 1; j++) {
                    if (currentNode.getData().compareTo(next.getData())) {
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;
                    }
                    currentNode = next;
                    next = next.getNext();
                }
            }
        }
    }
    public int compareTo(Node<SomeType> other){
        return this.data.compareTo(other.getData());
    }
    public void clear() {
        head = null;
        counter = 0;
    }

}
