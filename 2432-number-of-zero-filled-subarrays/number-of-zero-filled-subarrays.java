class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, c = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 0)
            {
                c++;
                res += c;
            }
            else
            {
                c=0;
            }
        }
        return res;
    }
}