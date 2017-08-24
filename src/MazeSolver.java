/**
 * solve method by Dr. Peroulli
 * main by TA Sean Flannery (sflanner)
 *
 */

public class MazeSolver {

	/* TODO
	Change the values of class variables below if you want to try other mazes
	*/


    public static int endRow;
    public static int endCol;

    public static char[][] maze = {{' ', ' ', ' '}, {'x','x',' '}, {' ',' ',' '}};

    public static int rows = maze.length;
    public static int cols = maze[0].length;

    public static void main(String[] args) {
        endRow = endCol = 2;
        System.out.println(solve(0,0));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%c ", maze[i][j]);
            }
            System.out.print("\n");
        }

    }

    private static boolean solve(int row, int col) {
        //handle special cases (out of bounds and walls)
        if (row < 0 || col < 00 || row >= rows || col >= cols || maze[row][col] != ' ')
            return false;

        //mark this location as on the path...
        maze[row][col] = '*';

        //basis case: see if we're done...
        if (row == endRow && col == endCol)
            return true;

        //recursive case: try surrounding spaces...
        if (solve(row-1, col) || solve(row+1, col) || solve(row, col-1) || solve(row, col+1))
            return true;

        //no solution found from this lcoation; backtrack and return failure...
        maze[row][col] = ' ';
        return false;
    }
}