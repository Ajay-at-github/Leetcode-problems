class Solution {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i=1; i<=n; i++)
        {
            arr[i-1] = i;
        }
        List<List<Integer>> res = permute(arr, k);
        List<Integer> dummy = res.get(res.size()-1);
        String str = "";
        for(int i=0; i<dummy.size(); i++)
        {
            str = str + dummy.get(i).toString();
        }
        return str;
    }
    public static void recur(int[] arr, List<Integer> ds, List<List<Integer>> ans, boolean[] freq, int k)
    {
        if(ds.size() == arr.length)
        {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(!freq[i])
            {
                if(ans.size()<k)
                {
                    freq[i] = true;
                    ds.add(arr[i]);
                    recur(arr, ds, ans, freq, k);
                    ds.remove(ds.size() - 1);
                    freq[i] = false;
                }
                else
                {
                    return;
                }
            }
        }
    }
    public static List<List<Integer>> permute(int[] arr, int k)
    {
        List<Integer> ds = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] freq = new boolean[arr.length];
        recur(arr, ds, ans, freq, k);
        return ans;
    }
}