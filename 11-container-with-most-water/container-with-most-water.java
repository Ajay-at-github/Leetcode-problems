class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int res = 0;
        while(l<r)
        {
            int c = (Math.min(height[l], height[r])) * (r - l);
            // System.out.println(c);
            if(height[l] < height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
            res = Math.max(res, c);
        }
        return res;
    }
}