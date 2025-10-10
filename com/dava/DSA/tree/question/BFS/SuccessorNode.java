package com.dava.DSA.tree.question.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SuccessorNode {
    public TreeNode successor(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if(currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}
