class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int ans=0,l=0,r=0;
        while(r<s.length())
        {
            if(!hs.contains(s.charAt(r)))
            {
                hs.add(s.charAt(r));
                ans=Math.max(ans,r-l+1);
                r++;
            }
            else
            {
                hs.remove(s.charAt(l));
                l++;
            }
        }
        return ans;
    }
}