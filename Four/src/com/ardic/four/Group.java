package com.ardic.four;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Group {

    private final ArrayList<Cell> cells = new ArrayList<Cell>();

    public Group() {
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void add(Cell cell) {
        this.cells.add(cell);
        cell.setGroup(this);
    }

    public void add(ArrayList<Cell> cells) {

        for(Cell cell : cells) {
            this.add(cell);
        }
    }

    public String toString() {
        return String.format("Size: %d, Cells: %s", this.getCells().size(), this.getCells().stream().map(Cell::toString).collect(Collectors.joining(", ")));
    }
}
