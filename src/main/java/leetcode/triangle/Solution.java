package leetcode.triangle;

import java.util.ArrayList;
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
        return minimum2(triangle, 0, 0);
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

    public int minimum2(List<List<Integer>> triangle, int row, int col) {
        if (row >= triangle.size() || col >= triangle.size()) {
            return 0;
        }
        if (mem[row][col] == 0) {
            mem[row][col] = Math.min(minimum2(triangle, row + 1, col), minimum2(triangle, row + 1, col + 1))
                    + triangle.get(row).get(col);
        }
        return mem[row][col];
    }

    // --------------------------------------------------------
    // dp
    public int minimumTotal2(List<List<Integer>> triangle) {
        int triangleSize = triangle.size();
        int[][] mins = new int[triangleSize][triangleSize];
        for (int c = 0; c < triangleSize; c++) {
            mins[triangleSize - 1][c] = triangle.get(triangleSize - 1).get(c);
        }
        for (int i = triangleSize - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                mins[i][j] = triangle.get(i).get(j) + Math.min(mins[i + 1][j], mins[i + 1][j + 1]);
            }
        }
        return mins[0][0];
    }

    // 用dp递推的话，上一次计算的结果不需要一直保存，所以可以用同个位置存储
    public int dp2(List<List<Integer>> triangle) {
        int triangleSize = triangle.size();
        int[] mins = new int[triangleSize + 1];
        for (int i = triangleSize - 1; i >= 0; i--) {
            // 上一个递推是从后往前，这里改成了从前往后，从后往前，将计算的结果直接保存在当前位置，会对前一个数的计算造成影响：
            // 如某行的第3列计算时需要下一行的3,4列，而第2列会用到下一行的2,3列，而从后往前会把第三列覆盖；
            // 反过来则不会，2列使用2,3列，覆盖第2列，而第3列的计算使用3,4列。
            for (int j = 0; j <= i; j++) {
                mins[j] = triangle.get(i).get(j) + Math.min(mins[j], mins[j + 1]);
            }
        }
        return mins[0];
    }

    /**
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        Solution s = new Solution();
        System.out.println(s.dp2(lists));
    }
}
