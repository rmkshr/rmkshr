package org.srv.leetcode.workbench;

public class TwoDimentionalArrays {
    public static void main(String[] args) {
        int[][] twoDmatrix = new int[5][5];
        twoDmatrix[0][0] = 1;
        twoDmatrix[0][1] = 2;
        twoDmatrix[0][2] = 3;
        twoDmatrix[0][3] = 4;
        twoDmatrix[0][4] = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(twoDmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
