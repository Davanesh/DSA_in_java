package com.dava.DSA.queue;

public class CustomQueue {
    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) {
            throw new Exception("the queue is empty");
        }
        int removed =  data[0];
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if(isEmpty()) {
            throw new Exception("the queue is empty");
        }
        return data[0];
    }

    public void displayQueue() {
        System.out.print("[");
        for(int val : data) {
            System.out.print(val + ", ");
        }
        System.out.print("]");
    }

    protected boolean isFull() {
        return end == data.length;
    }
    protected boolean isEmpty() {
        return end == 0;
    }
}
