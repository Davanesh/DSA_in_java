package com.dava.DSA.tree;

public class AVL {
    public AVL() {  }
    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
    private Node root;

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void display() {
        display(root, "Root Node");
    }
    private void display(Node node, String details) {
        if(node == null) return;
        System.out.println(details + node.getValue());
        display(node.left, "Left child " + node.getValue() + " : ");
        display(node.left, "Right child " + node.getValue() + " : ");
    }
    public void insert(int value) {
        insert(value, root);
    }
    private Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }
        if(value < node.value) {
            node.left = insert(value, node.left);
        }
        if(value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }
    private Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1) {
            // left heavy case
            if(height(node.left.left) - height(node.left.right) > 0) {
                // left-left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) <-1) {
            // right heavy case
            if(height(node.left.left) - height(node.left.right) < 0) {
                // left-left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) > 0) {
                // left-right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        } return node;
    }
    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = p.right;
        c.left = p;
        p.left = t;
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }
    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = c.left;
        p.left = c;
        c.right = t;
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return  p;
    }

    public boolean balance(Node node) {
        if(node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balance(node.left) && balance(node.right);
    }
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) { return; }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) { return; }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) { return; }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.value + " ");
    }
}
