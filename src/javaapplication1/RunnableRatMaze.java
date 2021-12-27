package javaapplication1;

public class RunnableRatMaze implements Runnable{

    RatMaze rat;
    int[][] maze;

    public RunnableRatMaze(int[][] maze) {
        this.maze=maze;
        rat=new RatMaze(maze[0].length);
    }

    @Override
    public void run() {
        rat.solveMaze(maze);
    }
}
