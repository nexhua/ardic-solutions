package com.ardic.four;

public class Cell {

    private final int value;

    private final int i;
    private final int j;

    private Group group = null;

    public Cell(int value,int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }

    public int getValue() {
        return value;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]->%d", this.getI(), this.getJ(), this.getValue());
    }
}
