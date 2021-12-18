package osproject;

public interface IRatMaze {

    void printSolution(int sol[][]);

    boolean isSafe(int[][] maze, int x, int y);

    boolean solveMaze(int[][] maze);

    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol);

}
