package com.ardic.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BTree {

    private Node root;

    public BTree(Node root) {
        this.root = root;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node);
            inOrder(node.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean isAnomaly() {
        Set<Node> seenNodes = new HashSet<>();
        ArrayList<Boolean> exists = new ArrayList<>();

        return traverseTree(this.getRoot(), seenNodes, exists).stream().reduce(false, (acc, elem) -> acc | elem);
    }

    private ArrayList<Boolean> traverseTree(Node node, Set<Node> seenNodes, ArrayList<Boolean> existList) {
        if (node != null) {

            boolean exists = seenNodes.add(node);
            existList.add(!exists);

            if (!exists) {
                return existList;
            }

            traverseTree(node.left, seenNodes, existList);
            traverseTree(node.right, seenNodes, existList);
        }

        return existList;
    }
}
