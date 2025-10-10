package com.dava.DSA.tree.question.DFS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    void helper(TreeNode node, List<String> list) {
        if(node == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

    // Decodes your encoded data to tree.
//    public TreeNode deserialize(List<String> data) {
//        Collections.reverse(data);
//        TreeNode node = helper2();
//        return node;
//    }
//    TreeNode helper2(List<String> list) {
//        String val = list.remove(list.size() - 1);
//        if (val == "null") {
//
//        }
//        TreeNode node = new TreeNode(Integer.parseInt(val));
//    }
}
