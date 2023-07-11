package com.ardic.four;

import java.util.*;

public class Board {

    private int N = 0;

    private Cell[][] Board;

    private ArrayList<Group> groups = new ArrayList<>();

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public Board(int size) {
        this.N = size;

        this.createBoard();
    }

    public Board(int[][] cells, int size) {
        this.N = size;
        this.Board = new Cell[this.N][this.N];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell(cells[i][j], i, j);
                this.Board[i][j] = cell;
            }
        }
    }

    private void createBoard() {
        Random random = new Random();
        this.Board = new Cell[this.N][this.N];
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                Cell cell = new Cell(random.nextInt(1, 10), i, j);
                this.Board[i][j] = cell;
            }
        }
    }

    public int checkBoard() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                Cell curr = this.Board[i][j];

                Cell right = tryGetCell(i, j + 1);
                Cell left = tryGetCell(i, j - 1);
                Cell up = tryGetCell(i - 1, j);
                Cell down = tryGetCell(i + 1, j);

                Cell[] neighbours = new Cell[]{up, down, left, right};

                compareNeighbours(curr, neighbours);

            }
        }

        return this.groups.size();
    }

    public int check() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                Cell curr = this.Board[i][j];

                if(curr.getGroup() != null) {
                    continue;
                }

                Cell right = tryGetCell(i, j + 1);
                Cell left = tryGetCell(i, j - 1);
                Cell up = tryGetCell(i - 1, j);
                Cell down = tryGetCell(i + 1, j);

                Cell[] neighbours = new Cell[]{up, down, left, right};

                compare(curr, neighbours);

            }
        }

        return this.groups.size();
    }


    private void compare(Cell curr, Cell[] neighbours) {
        List<Cell> neighbourMatches = filterNeighbours(curr, neighbours);

        // If we have a match
        if (neighbourMatches.size() > 0) {
            Group group = new Group();
            this.groups.add(group);

            searchGroup(curr, neighbourMatches, group);
        }

    }

    private void searchGroup(Cell curr, List<Cell> neighbours, Group group) {
        // Add current cell to the group. Being in a group also means visited.
        group.add(curr);

        // All adjacent matching neighbours are added to the queue
        Queue<Cell> queue = new LinkedList<>(neighbours);


        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            if (cell.getGroup() == null) {
                group.add(cell);
                queue.addAll(filterNeighbours(cell, getNeighbours(cell)).stream().filter(c -> c.getGroup() == null).toList());
            }

        }
    }

    private List<Cell> filterNeighbours(Cell curr, Cell[] neighbours) {
        return Arrays.stream(neighbours).filter(cell -> cell != null && cell.getValue() == curr.getValue()).toList();
    }

    private Cell[] getNeighbours(Cell center) {
        int i = center.getI();
        int j = center.getJ();

        Cell right = tryGetCell(i, j + 1);
        Cell left = tryGetCell(i, j - 1);
        Cell up = tryGetCell(i - 1, j);
        Cell down = tryGetCell(i + 1, j);

        return new Cell[]{up, down, left, right};
    }

    public void compareNeighbours(Cell curr, Cell[] neighbours) {

        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i] != null) {
                Cell neighbour = neighbours[i];
                // If they have the same value
                if (curr.getValue() == neighbour.getValue()) {

                    // If both of the cells are not in a group
                    if (curr.getGroup() == null && neighbour.getGroup() == null) {
                        Group group = new Group();

                        group.add(curr);
                        group.add(neighbour);

                        this.groups.add(group);
                    } // If only one of the cell is in a group
                    else if (curr.getGroup() == null ^ neighbour.getGroup() == null) {
                        if (curr.getGroup() != null) {
                            Group group = curr.getGroup();
                            group.add(neighbour);
                        } else {
                            Group group = neighbour.getGroup();
                            group.add(curr);
                        }

                    } // If both of the cells are in a group
                    else {
                        // If both cells in a group but the group is different, merge groups
                        if (curr.getGroup() != neighbour.getGroup()) {
                            int currGroupIndex = this.groups.indexOf(curr.getGroup());
                            int neighbourGroupIndex = this.groups.indexOf(neighbour.getGroup());

                            if (currGroupIndex != -1 && neighbourGroupIndex != -1) {
                                Group neighbourGroup = neighbour.getGroup();
                                curr.getGroup().add(neighbourGroup.getCells());
                                this.groups.remove(neighbourGroupIndex);
                            }
                        }
                    }

                }

            }
        }

    }


    public Cell tryGetCell(int i, int j) {
        if ((i >= 0 && i < this.N) && (j >= 0 && j < this.N)) {
            return this.Board[i][j];
        } else {
            return null;
        }
    }

    public void printBoard() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                System.out.format("%d ", this.Board[i][j].getValue());
            }
            System.out.println();
        }
    }

    public void printGroups() {
        for (Group group : this.getGroups()) {
            System.out.println(group.toString());
        }
    }
}

