package com.ardic.three;

public class Node {

    public Node left = null;
    public Node right = null;

    public Node() {

    }

    public void add(boolean isLeft) {
        if (isLeft) {
            this.left = new Node();
        } else {
            this.right = new Node();
        }
    }

    //region Getters and Setters

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
