/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;


/**
 *
 * @author Osama Ali
 */
public class OsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int N=grid.n;
        IRatMaze rat = new RatMaze(N);
        
        int maze[][]= grid.arr;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = inp.nextInt();
            }
        }

        rat.solveMaze(maze);
    }
}
    

