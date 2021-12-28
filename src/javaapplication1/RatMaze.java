package javaapplication1;

public class RatMaze implements IRatMaze{

    // Size of the maze
    static int N;
    static int sol[][];

    public RatMaze(int n){
        N = n;
    }

    /* A utility function to print
	solution matrix sol[N][N] */
    @Override
    public void printSolution(int sol[][]) {
        grid.sol=sol;
        for(int i=0; i<grid.n;i++){
            for(int j=0;j<grid.n;j++){
                if((i==0&&j==0)||(i==grid.n-1&&j==grid.n-1)){
                    continue;
                }
                if(sol[i][j]==1){
                    grid.cells[i][j].setBackground(grid.SolColor);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(
                        " " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* A utility function to check
		if x, y is valid index for N*N maze */
    @Override
    public boolean isSafe(int[][] maze, int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0
                && y < N && maze[x][y] == 1);
    }

    /* This function solves the Maze problem using
	Backtracking. It mainly uses solveMazeUtil()
	to solve the problem. It returns false if no
	path is possible, otherwise return true and
	prints the path in the form of 1s. Please note
	that there may be more than one solutions, this
	function prints one of the feasible solutions.*/
    @Override
    public boolean solveMaze(int[][] maze) {
        sol = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("Solution doesn't exist");
            grid.noSol();
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze
	problem */
    @Override
    public boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // Check if the current block is already part of solution path.
            if (sol[x][y] == 1) {
                return false;
            }

            // mark x, y as part of solution path
                sol[x][y] = 1;

            /* Move forward in x direction */

                if (solveMazeUtil(maze, x+1, y, sol)) {
                return true;
                }

            /* If moving in x direction doesn't give
			solution then Move down in y direction */
                if (solveMazeUtil(maze, x, y+1, sol)) {
                return true;
                }

            /* If none of the above movements works then
			BACKTRACK: unmark x, y as part of solution
			path */
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

}
