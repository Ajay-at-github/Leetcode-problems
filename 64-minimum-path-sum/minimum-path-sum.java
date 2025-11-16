class Solution {
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return func(m-1, n-1, dp, grid);
    }
    public int func(int i, int j, int[][] dp, int[][] grid)
    {
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + func(i-1, j, dp, grid);
        int left = grid[i][j] + func(i, j-1, dp, grid);
        return dp[i][j] = Math.min(up, left);
    }
}