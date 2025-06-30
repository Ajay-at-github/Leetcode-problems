class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return result(candidates, target);
    }
    public static void getComb(int i, int target, int[] candidates, List<Integer> ds, List<List<Integer>> ans)
	{
	    if(target==0)
	    {
            ans.add(new ArrayList<Integer>(ds));
	        return;
	    }
	    
	    for (int j=i; j<candidates.length; j++) 
	    {
            if (j>i && candidates[j] == candidates[j - 1]) 
            {
                continue;
            }
            if (candidates[j] > target) 
            {
                break;
            }
            ds.add(candidates[j]);
            getComb(j + 1, target - candidates[j], candidates, ds, ans);
            ds.remove(ds.size() - 1);
        }
	}
	public static List<List<Integer>> result(int[] candidates, int target) 
	{
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getComb(0, target, candidates, ds, ans);
        return ans;
    }
}