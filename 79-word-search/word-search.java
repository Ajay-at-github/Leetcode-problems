class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for(int r=0; r<board.length; r++)
        {
            for(int c=0; c<board[0].length; c++)
            {
                if(board[r][c] == arr[0] && dfs(r,c,0,board,arr))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int r, int c, int i, char[][]board, char[]arr)
    {
        if(arr.length==i)
        {
            return true;
        }
        if(r>=board.length || r<0 || c<0 || c>=board[0].length || board[r][c] != arr[i])
        {
            return false;
        }
        board[r][c] = '#';
        boolean found = (dfs(r+1, c, i+1, board, arr) || dfs(r-1, c, i+1, board, arr) || dfs(r, c+1, i+1, board, arr) || dfs(r, c-1, i+1, board, arr));
        
        board[r][c] = arr[i];
        return found;
    }
}