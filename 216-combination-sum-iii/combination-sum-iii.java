class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        return result(arr, k, n);
    }
    public static void getComb(int i, int n, int k, int[] arr, List<Integer> ds, List<List<Integer>> ans)
	{
	    if(n==0 && ds.size()==k)
	    {
            ans.add(new ArrayList<Integer>(ds));
	        return;
	    }
	    
	    
	    for (int j=i; j<arr.length; j++) 
	    {
            if (j>i && arr[j] == arr[j - 1]) 
            {
                continue;
            }
            if (arr[j] > n) 
            {
                break;
            }
            ds.add(arr[j]);
            getComb(j + 1, n - arr[j], k, arr, ds, ans);
            ds.remove(ds.size() - 1);
        }
	}
	public static List<List<Integer>> result(int[] arr, int k, int n) 
	{
        Arrays.sort(arr);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getComb(0, n, k, arr, ds, ans);
        return ans;
    }
}