package com.dava.DSA.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(50);
        list.insertFirst(60);
        list.insertFirst(70);
        list.display();
        list.insertLast(10);
        list.display();
        list.insert(30, 2);
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        list.insertAfter(60, 20);
        list.display();
    }
}
