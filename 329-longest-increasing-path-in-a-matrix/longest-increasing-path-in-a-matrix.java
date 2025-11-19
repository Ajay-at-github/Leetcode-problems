class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                dfs(i, j, -1, matrix, dp);
            }
        }

        int maxVal = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }
        return maxVal;
    }

    public int dfs(int r, int c, int prevVal, int[][] matrix, int[][] dp)
    {
        if(r < 0 || r == matrix.length || c < 0 || c == matrix[0].length || matrix[r][c] <= prevVal)
        {
            return 0;
        }
        if(dp[r][c] != -1) return dp[r][c];

        int res = 0;
        res = Math.max(res, 1 + dfs(r-1, c, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r+1, c, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r, c-1, matrix[r][c], matrix, dp));
        res = Math.max(res, 1 + dfs(r, c+1, matrix[r][c], matrix, dp));
        dp[r][c] = res;
        return res;
    }
}