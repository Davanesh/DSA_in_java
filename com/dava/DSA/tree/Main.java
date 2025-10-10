package com.dava.DSA.tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.prettyDisplay();

        int[] arr = {3, 8, 6, 7, -2, -8, 5, 9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
        System.out.println(segmentTree.query(1,6));
    }
}
