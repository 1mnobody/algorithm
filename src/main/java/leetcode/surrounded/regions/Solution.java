package leetcode.surrounded.regions;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve(new char[][]{{'O','X','O','O','O','X'},{'O','O','X','X','X','O'},{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}});
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> s = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !connectToBorder(board, i, j, visited, s)) {
                    s.forEach(idx -> {
                        String[] split = idx.split("@");
                        board[Integer.valueOf(split[0])][Integer.valueOf(split[1])] = 'X';
                    });
                }
                if (!s.isEmpty())  s.clear();
            }
        }
    }

    private boolean connectToBorder(char[][] board, int i, int j, boolean[][] visited, Set<String> s) {
        if (visited[i][j]) return false;
        if (s.contains(i+"@"+j)) return false;
        if (board[i][j] == 'O') {
            if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                return true;
            }
            visited[i][j] = true;
            boolean connected = (i > 0 && connectToBorder(board, i - 1, j, visited, s))
                    || (i < board.length - 1 && connectToBorder(board, i + 1, j, visited, s))
                    || (j > 0 && connectToBorder(board, i, j - 1, visited, s))
                    || (j < board[0].length - 1 && connectToBorder(board, i, j + 1, visited, s));
            visited[i][j] = false;
            if (!connected) s.add(i+"@"+j);
            return connected;
        }
        return false;
    }
}
