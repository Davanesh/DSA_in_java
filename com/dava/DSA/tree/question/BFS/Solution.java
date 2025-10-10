package com.dava.DSA.tree.question.BFS;

import java.util.*;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = false;
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if(!flag) {
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left != null) { deque.offerLast(currentNode.left); }
                    if(currentNode.right != null) { deque.offerLast(currentNode.right); }
                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);
                    if(currentNode.right != null) { deque.offerFirst(currentNode.right); }
                    if(currentNode.left != null) { deque.offerFirst(currentNode.left); }
                }
                flag = !flag;
            }
            result.add(currentLevel);
        }
        return result;
    }
    // leetcode 107 next pointer
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node currentNode = leftMost;
            while (currentNode != null) {
                currentNode.left.next = currentNode.right;
                if(currentNode.next != null) {
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
    //leetcode 993
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        return (level(root, xx , 0) == level(root, yy, 0) && (!isSibling(root, xx, yy)));
    }
    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) return false;
        return (node.left == x && node.right == y)
                || (node.left == y && node.right == x)
                || (isSibling(node.left, x, y))
                || (isSibling(node.right, x, y));
    }
    int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) return 0;
        if(node == x) return lev;
        int l = level(node.left, x, lev+1);
        if(l != 0) return l;
        return level(node.right, x, lev+1);
    }
    TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;
        if(node.val == x) return node;
        TreeNode n = findNode(node.left, x);
        if(n != null) return n;
        return findNode(node.right, x);
    }

    // 101 leetcode
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
