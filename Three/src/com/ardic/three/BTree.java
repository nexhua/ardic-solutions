package com.ardic.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BTree {

    private Node root;

    public BTree(Node root) {
        this.root = root;
    }

    public Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.getValue()) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.getValue());
            inOrder(node.right);
        }
    }

    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.getValue()) {
            return current;
        }
        return value < current.getValue()
                ? findNode(current.left, value)
                : findNode(current.right, value);
    }

    public Node find(int value) {
        return findNode(root, value);
    }

    public Node getRoot() {
        return root;
    }

    public boolean isAnomaly() {
        ArrayList<Node> seenNodes = new ArrayList<>();

        traverseTree(this.getRoot(), seenNodes);

        Set<Node> nodesSet = new HashSet<>();

        for(Node node : seenNodes) {
            boolean isAdded = nodesSet.add(node);

            // If we can't add node to set, it means we already visited it
            if(!isAdded) {
                return true;
            }
        }

        return false;
    }

    private void traverseTree(Node node, ArrayList<Node> seenNodes) {
        if (node != null) {
            traverseTree(node.left, seenNodes);
            seenNodes.add(node);
            traverseTree(node.right, seenNodes);
        }
    }
}
