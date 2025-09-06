class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, r=0;
        int len=0;
        int maxLen = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while(r < s.length())
        {
            if(hash[s.charAt(r)] != -1)
            {
                if(hash[s.charAt(r)] >= l)
                {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            len = r-l+1;
            hash[s.charAt(r)] = r;
            r++;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}