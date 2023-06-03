package com.ardic.three;

public class Node {

    private int value;

    public Node left = null;
    public Node right = null;

    public Node(int value) {
        this.value = value;
    }

    //region Getters and Setters

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //endregion
}
