class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return result(n, k);
    }
    public static void combination(int st, int n, int k, List<Integer> ds, List<List<Integer>> ans)
    {
        if(ds.size()==k)
        {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for (int i=st; i<=n; i++) 
        {
            ds.add(i);
            combination(i+1, n, k, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> result(int n, int k)
    {
        List<Integer> ds = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combination(1, n, k, ds, ans);
        return ans;
    }
}