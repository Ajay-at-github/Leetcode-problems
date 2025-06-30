class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return result(nums);
    }
    public static void getSubset(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans)
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        ds.add(nums[index]);
        getSubset(index+1, nums, ds, ans);
        ds.remove(ds.size()-1);
        getSubset(index+1, nums, ds, ans);

    }
    public static List<List<Integer>> result(int[] nums)
    {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        getSubset(index, nums, ds, ans);
        return ans;
    }
}