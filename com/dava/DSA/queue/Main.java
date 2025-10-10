package com.dava.DSA.queue;

public class Main {
    public static void main(String[] args) throws Exception{
        CircularQueue queue = new CircularQueue();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.displayQueue();
        queue.remove();
        queue.displayQueue();
    }
}
