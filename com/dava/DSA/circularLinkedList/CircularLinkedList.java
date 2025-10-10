package com.dava.DSA.circularLinkedList;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insert(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node temp = head;
        if(head != null) {
            do{
                System.out.print(temp.value + "->");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    public void delete(int value) {
        Node temp = head;
        if(temp == null) {
            return;
        }
        if(temp.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = temp.next;
            if(n.value == value) {
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }
    public int len(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                int length = 0;
                Node temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;              }
        }
        return 0;
    }
}
