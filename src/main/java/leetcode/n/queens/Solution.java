package leetcode.n.queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * n皇后问题
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Created by wuzhsh on 11/11/2019.
 */
public class Solution {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solve(res, new int[n][n], 0, n);
        return res;
    }

    private void solve(List<List<String>> res, int[][] board, int curRow, int n) {
        // 每行都放了queen了，将这种方案保存
        if (curRow >= n) {
            res.add(toString(board));
            return;
        }
        // 查询 curRow行中的每一列，放置 queen 的可行性
        for (int col = 0; col < n; col++) {
            if (legal(board, curRow, col)) {
                board[curRow][col] = 1;
                solve(res, board, curRow + 1, n);
                // board 存储了queen的存放信息，方法从下层返回时，说明已经确定了这个位置是否可以放置queen，最终的结果会体现在
                // res中，后续要再判断下一个位置，两次循环是独立的，所以这里要恢复为0，不能影响下一个位置的放置判定
                board[curRow][col] = 0;
            }
        }
    }

    private List<String> toString(int[][] board) {
        return Arrays.stream(board)
                .map(row -> Arrays.stream(row)
                        .mapToObj(i -> i == 1 ? "Q" : ".")
                        .reduce((s1, s2) -> s1 + s2)
                        .orElse(""))
                .collect(Collectors.toList());

    }

    // 判断棋盘中 curRow, curCol位置是否可以放置
    private boolean legal(int[][] board, int curRow, int curCol) {
        for (int row = 0; row < curRow; row++) {
            if (board[row][curCol] == 1)
                return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (row + col == curRow + curCol && board[row][col] == 1) {
                    return false;
                }
                if (row - col == curRow - curCol && board[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
