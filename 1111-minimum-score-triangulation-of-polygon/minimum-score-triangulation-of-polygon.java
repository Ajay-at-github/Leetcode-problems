class Solution {
    public int minScoreTriangulation(int[] values)
    {
        return func(values, 0, 0, 0);
    }
    public int[][] dp = new int[50][50];
    
    public int func(int[] values, int i, int j, int res) {
        if (j == 0) j = values.length - 1;
        if (dp[i][j] != 0) return dp[i][j];
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res == 0 ? Integer.MAX_VALUE : res,
                func(values, i, k, 0) +
                values[i] * values[k] * values[j] +
                func(values, k, j, 0));
        }
        return dp[i][j] = res;
    }
}