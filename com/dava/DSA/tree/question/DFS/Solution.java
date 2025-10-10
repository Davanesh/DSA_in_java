package com.dava.DSA.tree.question.DFS;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    // leetcode 543
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }
    int height(TreeNode node) {
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        int dia = left + right + 1;
        diameter = Math.max(dia, diameter);
        return Math.max(left, right) + 1;
    }

    // 226 leetcode
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // leetcode 114
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if(current.left != null) {
                TreeNode temp = current.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // leetcode 98
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;
        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val, high);
        return leftTree && rightTree;
    }

    // leetcode 236
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if(p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    // leetcode 105
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int r = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == r);
            index = i;
        }
        TreeNode root = new TreeNode(r);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;
    }

    // leetcode 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) return true;
        boolean left = hasPathSum(root.left, targetSum-root.val);
        if(left) return left;
        boolean right = hasPathSum(root.right, targetSum-root.val);
        return left || right;
    }

    // leetcode 129
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
    int getSum(TreeNode node, int sum) {
        if(node == null) return 0;
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null) return sum;
        return  getSum(node.left, sum) + getSum(node.right, sum);
    }

    // leetcode 124
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return ans;
    }
    int maxSum(TreeNode node) {
        if (node == null) return 0;

        int left = maxSum(node.left);
        int right = maxSum(node.left);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + node.val;

        ans = Math.max(ans, pathSum);

        return Math.max(left, right) + node.val;
    }
    // pathExists
    boolean findPath(TreeNode node, int[] arr) {
        if(node == null) return arr.length == 0;
        return findPathHelper(node, arr, 0);
    }
    boolean findPathHelper(TreeNode node, int[] arr, int index) {
        if (node == null) return false;
        if(index >= arr.length || node.val != arr[index]) return false;
        if(node.left == null && node.right == null && index == arr.length - 1) return true;
        return findPathHelper(node.left, arr, index + 1) || findPathHelper(node.right, arr, index + 1);
    }
    // total path
    int countPath(TreeNode node, int sum) {
        List<Integer> path = new LinkedList<>();
        return count(node, sum, path);
    }

    private int count(TreeNode node, int sum, List<Integer> path) {
        if (node == null) return 0;
        path.add(node.val);
        int count = 0;
        int pathSum = 0 ;
        count += count(node.left, sum, path) + count(node.right, sum, path);
        path.remove(path.size());
        return count;
    }
}
