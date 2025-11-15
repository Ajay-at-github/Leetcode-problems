class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
        if (inicolor == color) return image;
        int[][] ans = image;
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, +1, 0, -1};
        dfs(image, ans, sr, sc, color, inicolor, dr, dc);
        return ans;
    }

    public void dfs(int[][] image, int[][] ans, int sr, int sc, int color, int inicolor, int[] dr, int[] dc)
    {
        ans[sr][sc] = color;
        int n = ans.length;
        int m = ans[0].length;
        for(int i=0; i<4; i++)
        {
            int nrow = sr + dr[i];
            int ncol = sc + dc[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == inicolor && ans[nrow][ncol] != color)
            {
                dfs(image, ans, nrow, ncol, color, inicolor, dr, dc);
            }
        }
    }
}