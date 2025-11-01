class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l=0, r=0, maxlen = 0;

        while(r < s.length())
        {
            if(hash[s.charAt(r)] != -1)
            {
                if(hash[s.charAt(r)] >= l)
                {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxlen = Math.max(r-l+1, maxlen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}