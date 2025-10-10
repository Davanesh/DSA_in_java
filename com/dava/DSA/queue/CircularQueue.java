package com.dava.DSA.queue;

public class CircularQueue {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    protected boolean isFull() {
        return end == data.length;
    }
    protected boolean isEmpty() {
        return end == 0;
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) {
            throw new Exception("the queue is empty");
        }
        int remove = data[front++];
        front = front % data.length;
        size++;
        return remove;
    }

    public int front() throws Exception {
        if(isEmpty()) {
            throw new Exception("the queue is empty");
        }
        return data[front];
    }

    public void displayQueue() {
        for(int i = front; i < end; i++) {
            System.out.print(data[i] + "->");
        }
        System.out.print("END");
    }
}
