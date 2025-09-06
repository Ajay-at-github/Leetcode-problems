class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0, r=0;
        int maxLen=0;

        while(r<nums.length)
        {
            if(nums[r] == 1)
            {
                r++;
            }
            else
            {
                l=r+1;
                r++;
            }
            maxLen = Math.max(maxLen, r-l);
        }
        return maxLen;
    }
}