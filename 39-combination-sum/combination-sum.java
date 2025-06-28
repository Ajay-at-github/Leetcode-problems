class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] n = candidates;
        int k = target;
        return result(n, k);
    }
    
    public static void combination(int start, int[] n, int k, List<Integer> ds, List<List<Integer>> ans)
    {
        if(start==n.length)
        {
            if(k==0)
            {
                ans.add(new ArrayList<Integer>(ds));
            }
            return;  
        }
        
        if(n[start]<=k)
        {
            ds.add(n[start]);
            combination(start, n, k-n[start], ds, ans);
            ds.remove(ds.size()-1);
        }
        combination(start+1, n, k, ds, ans);
        
    }
    
    public static List<List<Integer>> result(int[] n, int k)
    {
        List<Integer> ds = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combination(0, n, k, ds, ans);
        return ans;
    }
}