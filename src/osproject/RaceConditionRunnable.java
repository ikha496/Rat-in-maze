package osproject;

public class RaceConditionRunnable implements Runnable{
    private int[][]maze;
    private int x;
    private int y;
    private int[][]sol;
    private RatMaze rat;
public RaceConditionRunnable(int[][]maze,int x,int y,int[][]sol,RatMaze rat){
    this.maze=maze;
    this.x=x;
    this.y=y;
    this.sol=sol;
    this.rat=rat;
}


@Override
    public void run() {
     rat.solveMazeUtil(maze, x , y, sol);
    }
}
