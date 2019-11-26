package leetcode.surrounded.regions;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve2(new char[][]{{'O', 'X', 'O', 'O', 'O', 'X'}, {'O', 'O', 'X', 'X', 'X', 'O'}, {'X', 'X', 'X', 'X', 'X', 'O'}, {'O', 'O', 'O', 'O', 'X', 'X'}, {'X', 'X', 'O', 'O', 'X', 'O'}, {'O', 'O', 'X', 'X', 'X', 'X'}});
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
                if (!s.isEmpty()) s.clear();
            }
        }
    }

    private boolean connectToBorder(char[][] board, int i, int j, boolean[][] visited, Set<String> s) {
        if (visited[i][j]) return false;
        if (s.contains(i + "@" + j)) return false;
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
            if (!connected) s.add(i + "@" + j);
            return connected;
        }
        return false;
    }

    private void printBoard(char[][] board) {
        Arrays.stream(board).forEach(line -> {
            for (char c : line) {
                System.out.print(c + " , ");
            }
            System.out.println();
        });
    }

    // 找到从4条边连通的所有O（大o），这些位置不能变成X，剩下的所有元素都可直接修改为X
    public void solve2(char[][] board) {
        if (board == null || board.length == 0) return;
//        boolean[][] visited = new boolean[board.length][board[0].length];
        printBoard(board);
        for (int j = 0; j < board[0].length; j++) {
            connectToBorder2(board, 0, j);
            connectToBorder2(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            connectToBorder2(board, i, 0);
            connectToBorder2(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

//        System.out.println("-------------------------------");
//        printBoard(board);

    }

    private void connectToBorder2(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '.';
            if (i > 0)
                connectToBorder2(board, i - 1, j);
            if (i < board.length - 1)
                connectToBorder2(board, i + 1, j);
            if (j > 0)
                connectToBorder2(board, i, j - 1);
            if (j < board[0].length - 1)
                connectToBorder2(board, i, j + 1);
        }
    }
}
