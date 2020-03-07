package leetcode.pacific.atlantic.water.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuzhsh on 12/20/2019.
 */
public class Solution {

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        res.clear();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int length = matrix.length;
        int width = matrix[0].length;
        // 0 太平洋， 1 大西洋
        boolean[][][] mem = new boolean[length][width][2];
        int mlen = length > width ? length : width;
        // 初始化
        for (int i = 0; i < mlen; i++) {
            if (i < width) {
                mem[0][i][0] = true;
                mem[length - 1][i][1] = true;
            }
            if (i < length) {
                mem[i][0][0] = true;
                mem[i][width - 1][1] = true;
            }
        }

        // 新元素加入可能会导致另外一个新元素的加入，所以这里使用一个循环
        boolean findNew;
        // 处理太平洋
        do {
            findNew = false;
            for (int i = 1; i < length; i++) {
                for (int j = 1; j < width; j++) {
                    if (!mem[i][j][0]) {
                        if ((mem[i - 1][j][0] && matrix[i][j] >= matrix[i - 1][j])
                                || (mem[i][j - 1][0] && matrix[i][j] >= matrix[i][j - 1])
                                || (i < length - 1 && mem[i + 1][j][0] && matrix[i][j] >= matrix[i + 1][j])
                                || (j < width - 1 && mem[i][j + 1][0] && matrix[i][j] >= matrix[i][j + 1])) {
                            mem[i][j][0] = true;
                            findNew = true;
                        }
                    }
                }
            }
        } while (findNew);

        // 处理大西洋
        do {
            findNew = false;
            for (int i = length - 2; i >= 0; i--) {
                for (int j = width - 2; j >= 0; j--) {
                    if (!mem[i][j][1]) {
                        if ((mem[i + 1][j][1] && matrix[i][j] >= matrix[i + 1][j])
                                || (mem[i][j + 1][1] && matrix[i][j] >= matrix[i][j + 1])
                                || (i > 0 && mem[i - 1][j][1] && matrix[i][j] >= matrix[i - 1][j])
                                || (j > 0 && mem[i][j - 1][1] && matrix[i][j] >= matrix[i][j - 1])) {
                            mem[i][j][1] = true;
                            findNew = true;
                        }
                    }
                }
            }
        } while (findNew);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (mem[i][j][0] && mem[i][j][1]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private static void printMatrix(boolean[][][] mem) {
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                System.out.print("[" + i + "," + j + "]:" + (mem[i][j][0] ? "1" : "0") + "\t\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                System.out.print("[" + i + "," + j + "]:" + (mem[i][j][1] ? "1" : "0") + "\t\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
        int[] a1 = new int[]{1, 2, 3};
        int[] a2 = new int[]{8, 9, 4};
        int[] a3 = new int[]{7, 6, 5};
        int[][] matrix = new int[][]{a1, a2, a3};
        System.out.println(pacificAtlantic(matrix));
        // [[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]

        int[] b1 = new int[]{1, 2, 2, 3, 5};
        int[] b2 = new int[]{3, 2, 3, 4, 4};
        int[] b3 = new int[]{2, 4, 5, 3, 1};
        int[] b4 = new int[]{6, 7, 1, 4, 5};
        int[] b5 = new int[]{5, 1, 1, 2, 4};
        int[][] matrix2 = new int[][]{b1, b2, b3, b4, b5};
        System.out.println(pacificAtlantic(matrix2));


        int[][] matrix3 = new int[][]{
                {8, 13, 11, 18, 14, 16, 16, 4, 4, 8, 10, 11, 1, 19, 7},
                {2, 9, 15, 16, 14, 5, 8, 15, 9, 5, 14, 6, 10, 15, 5},
                {15, 16, 17, 10, 3, 6, 3, 4, 2, 17, 0, 12, 4, 1, 3},
                {13, 6, 13, 15, 15, 16, 4, 10, 7, 4, 19, 19, 4, 9, 13},
                {7, 1, 9, 14, 9, 11, 5, 4, 15, 19, 6, 0, 0, 13, 5},
                {9, 9, 15, 12, 15, 5, 1, 1, 18, 1, 2, 16, 15, 18, 9},
                {13, 0, 4, 18, 12, 0, 11, 0, 1, 15, 1, 15, 4, 2, 0},
                {11, 13, 12, 16, 9, 18, 6, 8, 18, 1, 5, 12, 17, 13, 5},
                {7, 17, 2, 5, 0, 17, 9, 18, 4, 13, 6, 13, 7, 2, 1},
                {2, 3, 9, 0, 19, 6, 6, 15, 14, 4, 8, 1, 19, 5, 9},
                {3, 10, 5, 11, 7, 14, 1, 5, 3, 19, 12, 5, 2, 13, 16},
                {0, 8, 10, 18, 17, 5, 5, 8, 2, 11, 5, 16, 4, 9, 14},
                {15, 9, 16, 18, 9, 5, 2, 5, 13, 3, 10, 19, 9, 14, 3},
                {12, 11, 16, 1, 10, 12, 6, 18, 6, 6, 18, 10, 9, 5, 2},
                {17, 9, 6, 6, 14, 9, 2, 2, 13, 13, 15, 17, 15, 3, 14},
                {18, 14, 12, 6, 18, 16, 4, 10, 19, 5, 6, 8, 9, 1, 6}
        };
        System.out.println(pacificAtlantic(matrix3));
        // [[0,13],[0,14],[1,13],[11,3],[12,0],[12,2],[12,3],[13,0],[13,1],[13,2],[14,0],[15,0]]
    }
}
