package com.dava.DSA.singlyLinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    public LinkedList() {
        this.size = 0;
    }

    private class Node {
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

    public void insertFirst(int val) {
        Node node = new Node(val); // let the val = 10 so, [ 10 | next -> null ]
        node.next = head; // [10 | next -> head] head is null initially
        head = node; // [ head ] -> [ 10 | next -> null ]

        if(tail == null) { // true for first attend
            tail = head; // [ head ] and [ tail ] -> [ 10 | next -> null ]
        }

        size += 1;
    }
    // let the next val is 20 so, [ 20 | next -> null ]
    // [ 20 | next ] and [ tail ] -> [ 10 | next -> null ]
    // [ head ] -> [ 20 | next ] and [ tail ] -> [ 10 | next -> null ]

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
        } else {
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
        }
        Node temp = head;
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Bruh, list already empty 😐");
            return;
        }
        int val = head.value;
        head = head.next;
        size--;
        if(head == null) {
            // We just deleted the last node, so tail should also be null
            tail = null;
        }
        System.out.println("the deleted node was: " + val);
    }

    public void deleteLast() {
        if(size <= 1) {
            deleteFirst();
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        tail.next = null;
        tail = temp;
        System.out.println("the deleted node is: " + val);
        size--;
    }
    public void delete(int index) {
        if(index == 0) {
            deleteFirst();
        }
        if(index == size - 1) {
            deleteLast();
        }
        Node temp = head;
        for(int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        System.out.println("the deleted node is: " + val);
        temp.next = temp.next.next;
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

//    private Node insertRec(int value, int index, Node node) {
//        if(index == 0) {
//            Node temp = new Node(value, node);
//            size++;
//        }
//    }
//
//    //insert using recursion
//    public void insertRec(int value, int index) {
//
//    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }
    private void bubbleSort(int r, int c) {
        if(r == 0) return;
    }

    // leetcode 83
    public void duplicates() {
        if(head == null) return;
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // leetcode 21
    public LinkedList merge(LinkedList first, LinkedList second) {
        LinkedList ans = new LinkedList();
        Node f = first.head;
        Node s = second.head;
        while(f != null && s != null) {
            if(f.value <= s.value ) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }
        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
    public void reverse(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    public Node reverse2(Node head) {
        if(head == null) return head;
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}
