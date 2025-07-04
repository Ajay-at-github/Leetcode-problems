class Solution {
    public int numTilePossibilities(String tiles) {
       int[] count = new int[26];
       int i = 0;
        for (char c : tiles.toCharArray()) 
        {
            count[c - 'A']++;
        }
        return backtrack(count);
    }

    public int backtrack(int[] count)
    {
        int res = 0;
        for (int i = 0; i < 26; i++) 
        {
            if (count[i] == 0) continue;
            count[i]--;
            res += 1;
            res += backtrack(count);
            count[i]++;
        }
        return res;
    }
}