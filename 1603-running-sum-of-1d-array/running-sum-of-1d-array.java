class Solution {
    public int[] runningSum(int[] nums) {
		int arr[] = new int[nums.length];
		helper(nums, 0, arr, 0);
		return arr;
	}
	public static int[] helper(int nums[], int i, int[] arr, int res)
	{
	    res = res + nums[i];
    	arr[i] = res;
    	
	    if(i==nums.length-1)
	    {
    	    return arr;
    	    
	    }
	    else
	    {
	        return helper(nums, i+1, arr, res);
	    }
    }
}