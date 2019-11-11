package leetcode.triangle;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example:
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * out: 11 (2+3+5+1=11)
 */
public class Solution {
    int[][] mem;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        mem = new int[n][triangle.get(n - 1).size()];
        return minimum(triangle, 0, 0);
    }

    public int minimum(List<List<Integer>> triangle, int row, int col) {
        if (triangle.size() == row) {
            return 0;
        }
        if (mem[row][col] == 0) {
            mem[row][col] = triangle.get(row).get(col) +
                    Math.min(minimum(triangle, row + 1, col), minimum(triangle, row + 1, col + 1));
        }
        return mem[row][col];
    }


    // --------------------------------------------------------
    // dp
    public int minimumTotal2(List<List<Integer>> triangle) {
        int triangleSize = triangle.size();
        int[][] mins = new int[triangleSize][triangleSize];
        for (int c = 0; c < triangleSize; c++) {
            mins[triangleSize-1][c] = triangle.get(triangleSize-1).get(c);
        }
        for (int i = triangleSize - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                mins[i][j] = triangle.get(i).get(j) + Math.min(mins[i+1][j], mins[i+1][j+1]);
            }
        }
        return mins[0][0];
    }
}
