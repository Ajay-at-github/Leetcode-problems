class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp = 0;
        for (int i=0; i<m; i++)
        {
            for (int j=i; j<n; j++) 
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int l=0, r=n-1;
        for(int i=0; i<m; i++)
        {
            while(l<=r)
            {
                temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;

                l++;
                r--;
            }
            l=0;
            r=n-1;
        }
    }
}