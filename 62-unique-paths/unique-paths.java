// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for (int i=0; i<m; i++) 
//         {
//             Arrays.fill(dp[i], -1);
//         }
//         return func(m-1, n-1, dp);
//     }
//     public int func(int i, int j, int[][] dp)
//     {
//         if(i == 0 && j == 0) return 1;
//         if(i < 0 || j < 0) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
//         int up = func(i-1, j, dp);
//         int left = func(i, j-1, dp);

//         return dp[i][j] = up + left;
//     }
// }

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for (int x=0; x<m; x++) 
//         {
//             Arrays.fill(dp[x], -1);
//         }

//         for(int i=0; i<m; i++)
//         {
//             for(int j=0; j<n; j++)
//             {
//                 int up = 0, left = 0;
//                 if(i == 0 && j == 0) dp[0][0]=1;
//                 else
//                 {
//                     if(i > 0) up = dp[i-1][j];
//                     if(j > 0) left = dp[i][j-1];
//                     dp[i][j] = up+left;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for(int i=0; i<m; i++)
        {
            int[] curr = new int[n];
            for(int j=0; j<n; j++)
            {
                int up = 0, left = 0;
                if(i == 0 && j == 0) curr[j]=1;
                else
                {
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j-1];
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}