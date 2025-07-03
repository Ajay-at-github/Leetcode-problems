class Solution {
    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) 
        {
            Arrays.fill(board[i], '.');
        }
        int[] count = new int[1];
        backtrack(count, board, 0, n);
        return count[0];
    }

    public static void backtrack(int[] count, char[][] board, int col, int n)
    {
        if(col == n)
        {
            count[0]++;
            return;
        }

        for(int row=0; row<n; row++)
        {
            if(isSafe(row, col, board, n))
            {
                board[row][col] = 'Q';
                backtrack(count, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, char[][] board, int n)
    {
        int r = row;
        int c = col;

        while(r>=0 && c>=0)
        {
            if(board[r--][c--] == 'Q') return false;
        }

        r = row;
        c = col;
        while(c>=0)
        {
            if(board[r][c--] == 'Q') return false;
        }

        r = row;
        c = col;
        while(r<n && c>=0)
        {
            if(board[r++][c--] == 'Q') return false;
        }
        return true;
    }
}