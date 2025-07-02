import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(ans, board, 0, n);
        return ans;
    }

    private void backtrack(List<List<String>> ans, char[][] board, int col, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                backtrack(ans, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row, c = col;

        while (r >= 0 && c >= 0)
            if (board[r--][c--] == 'Q') return false;

        r = row; c = col;
        while (c >= 0)
            if (board[r][c--] == 'Q') return false;

        r = row; c = col;
        while (r < n && c >= 0)
            if (board[r++][c--] == 'Q') return false;

        return true;
    }
}
