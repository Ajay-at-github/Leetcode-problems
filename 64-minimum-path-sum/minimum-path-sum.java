// class Solution {
//     public int minPathSum(int[][] grid) 
//     {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] dp = new int[m][n];
//         for(int i=0; i<dp.length; i++)
//         {
//             Arrays.fill(dp[i], -1);
//         }
//         return func(m-1, n-1, dp, grid);
//     }
//     public int func(int i, int j, int[][] dp, int[][] grid)
//     {
//         if(i==0 && j==0) return grid[i][j];
//         if(i<0 || j<0) return (int)1e9;
//         if(dp[i][j] != -1) return dp[i][j];
//         int up = grid[i][j] + func(i-1, j, dp, grid);
//         int left = grid[i][j] + func(i, j-1, dp, grid);
//         return dp[i][j] = Math.min(up, left);
//     }
// }




// class Solution {
//     public int minPathSum(int[][] grid) 
//     {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] dp = new int[m][n];
//         for(int i=0; i<dp.length; i++)
//         {
//             Arrays.fill(dp[i], -1);
//         }

//         for(int i=0; i<m; i++)
//         {
//             for(int j=0; j<n; j++)
//             {
//                 if(i==0 && j==0) dp[i][j] = grid[i][j];
//                 else
//                 {
//                     int up = grid[i][j];
//                     if(i > 0) up = grid[i][j] + dp[i-1][j];
//                     else up = (int)1e9;

//                     int left = grid[i][j];
//                     if(j > 0) left = grid[i][j] + dp[i][j-1];
//                     else left = (int)1e9;

//                     dp[i][j] = Math.min(up, left);
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }



class Solution {
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];
        for(int i=0; i<m; i++)
        {
            int[] curr = new int[n];
            for(int j=0; j<n; j++)
            {
                if(i==0 && j==0) curr[j] = grid[i][j];
                else
                {
                    int up = grid[i][j];
                    if(i > 0) up = grid[i][j] + prev[j];
                    else up = (int)1e9;

                    int left = grid[i][j];
                    if(j > 0) left = grid[i][j] + curr[j-1];
                    else left = (int)1e9;

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}