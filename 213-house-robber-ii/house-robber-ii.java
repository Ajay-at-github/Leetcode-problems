class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        if(n == 1) return nums[0];
        for(int i=0; i<n; i++)
        {
            if(i != 0) temp1[i] = nums[i];
            if(i != n-1) temp2[i] = nums[i];
        }
        return Math.max(func(temp1), func(temp2));
    }
    public int func(int arr[]) 
    {
        int n = arr.length;
        int prev = arr[0];
        int prev2 = 0;
        
        for(int i=1; i<n; i++)
        {
            int t = arr[i];
            if(i > 1)
            {
                t += prev2;
            }
            int nt = prev;
            int curr = Math.max(t, nt);
            prev2 = prev;
            prev= curr;
        }
        return prev;
    }
}