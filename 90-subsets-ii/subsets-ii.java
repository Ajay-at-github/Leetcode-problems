class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return result(nums);
    }
    public static void getSubset(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<Integer>(ds));
    
        for(int i = index; i<nums.length; i++)
        {
            if(i>index && nums[i]==nums[i-1])
            {
                continue;
            }
            ds.add(nums[i]);
            getSubset(i+1, nums, ds, ans);
            ds.remove(ds.size()-1);
        }

    }
    public static List<List<Integer>> result(int[] nums)
    {
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        getSubset(index, nums, ds, ans);
        return ans;
    }
}