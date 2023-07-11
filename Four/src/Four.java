import com.ardic.four.Board;

public class Four {
    public static void main(String[] args) {
        // Initialize board with hardcoded 2D array

        // int[][] cells =  {{1,5,2,9}, {8,7,2,6}, {6,4,3,1}, {9,4,4,7}};
        // Board board = new Board(cells, cells.length);

        // Randomly initialized board
        Board board = new Board(10);

        board.printBoard();

        System.out.println("\nGroup count: " + board.check());

        System.out.println("\nEach group and cells in that group:");
        board.printGroups();

    }
}
