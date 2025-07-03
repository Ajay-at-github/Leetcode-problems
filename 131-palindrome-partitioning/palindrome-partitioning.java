class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> ds = new ArrayList<String>();
        int index = 0;
        backtrack(index, s, ans, ds);
        return ans;
    }

    public void backtrack(int index, String s, List<List<String>> ans, List<String> ds)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList<String> (ds));
            return;
        }

        for(int i=index; i<s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                ds.add(s.substring(index, i+1));
                backtrack(i+1, s, ans, ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}