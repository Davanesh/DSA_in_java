package com.dava.DSA.circularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        for (int i = 1; i <= 10; i++) {
            circularLinkedList.insert(i);
        }
        circularLinkedList.display();
        circularLinkedList.delete(5);
        circularLinkedList.display();
//        circularLinkedList.len();
    }
}
