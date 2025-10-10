package com.dava.DSA.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public DoublyLinkedList() {
        this.size = 0;
    }
    public class Node {
        private Node prev;
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "<=>");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if(tail == null) {
            insertFirst(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }

    public void insert(int value, int index) {
        if(index == 0) { insertFirst(value); }
        if(index == size) { insertLast(value); }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Bruh, list already empty 😐");
            return;
        }
        int val = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        System.out.println("the deleted node was: " + val);
    }

    public void deleteLast() {
        if(size <= 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for(int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = null;
        tail = temp;
        System.out.println("the deleted node is: " + val);
        size--;
    }

    public void delete(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
    }

    public Node find(int value) {
        Node find = head;
        while (find != null) {
            if(find.value == value) {
                return find;
            }
            find = find.next;
        }
        return null;
    }

    public void insertAfter(int after, int value) {
        Node temp = find(after);
        if(temp == null) {
            System.out.println("Node doesn't exist");
            return;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        if(temp.next != null) { temp.next.prev = node; }
    }
}
