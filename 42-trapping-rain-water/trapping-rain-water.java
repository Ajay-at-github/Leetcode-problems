class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int l = 0;
        int r = height.length - 1;
        int lm = height[l];
        int rm = height[r];
        int res = 0;

        while(l<r)
        {
            if(lm <= rm)
            {
                l += 1;
                lm = Math.max(lm, height[l]);
                res += lm - height[l];
            }
            else
            {
                r -= 1;
                rm = Math.max(rm, height[r]);
                res += rm - height[r];
            }
        }
        return res;
    }
}