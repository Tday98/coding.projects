/**
 * The Game of Life (Conway)
 *
 * A program to simulate Conway's game of life.
 *
 * @author John T Korb
 *
 * @date 2/8/13
 */

public class Life {
    boolean[][] board; // the 2D board to hold life forms

    /**
     * Constructs a 2D board and initializes life at random.
     *
     * @param rows the number of rows in the board.
     * @param cols the number of columns in the board.
     */
    Life(int rows, int cols) {
        board = new boolean[rows][cols];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = Math.random() > 0.9;
            }
        }
    }

    /**
     * Counts the number of (live) neighbors of the square.
     *
     * @param row the row number of the square.
     * @param col the column number of the square.
     * @return the number of live neighbors of the square.
     */
    int countNeighbors(int row, int col) {
        // use drdc as a "differential matrix" to "walk around" the current square...
        int[][] drdc = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }};
        int neighbors = 0;

        // visit the eight adjacent cells, avoiding off-board squares...
        for (int i = 0; i < drdc.length; i++) {
            int r = row + drdc[i][0];
            int c = col + drdc[i][1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c])
                neighbors++;
        }
        return neighbors;
    }

    /**
     * Updates the board with the next generation of life forms.
     *
     * Rules applied to each cell:
     *
     * 1. Live cell with 0 or 1 neighbors: dies from loneliness.
     * 2. Live cell with 2 or 3 neighbors: continues to live.
     * 3. Live cell with more than 3 neighbors: dies of overcrowding.
     * 4. Dead cell with exactly three neighbors: a new life is formed.
     */
    void update() {
        // create a board to house the next generation...
        boolean[][] next = new boolean[board.length][board[0].length];

        // visit each cell in current board and apply rules
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++ ) {
                int neighbors = countNeighbors(row, col);
                if (board[row][col]) // rules for living cells...
                    next[row][col] = (neighbors == 2 || neighbors == 3);
                else // rule for dead cells...
                    next[row][col] = (neighbors == 3);
            }
        }

        // make the next board be the current board...
        board = next;
    }

    /**
     * Prints the board on the display.  Works best with a standard terminal window (not DrJava).
     */
    void printBoard() {
        // clear the display...
        for (int i = 0; i < 100; i++)
            System.out.println();

        // print each row a column at a time...
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col])
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * main method used for testing and experiments.
     */
    public static void main(String[] args) {
        final int ROWS = 24;
        final int COLUMNS = 80;
        final int GENERATIONS = 100;

        // Create the board and print the initial setup...
        Life life = new Life(ROWS, COLUMNS);
        life.printBoard();

        // Loop for the number of generations: update, print, sleep...
        for (int generation = 0; generation < GENERATIONS; generation++) {
            life.update();
            life.printBoard();
            try { Thread.sleep(500); } catch (InterruptedException e) { }
        }
    }
}
