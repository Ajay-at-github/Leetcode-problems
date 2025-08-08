// Brute Force Soltuion (3^N)

// class Solution {
//     public boolean checkValidString(String s) {
//         // return func(0, s, 0);
//     }
//     static boolean func(int idx, String s, int c)
//     {
//         if(c < 0) return false;
//         if(idx == s.length())
//         {
//             return (c==0);
//         }
//         if(s.charAt(idx) == '(')
//         {
//             return func(idx+1, s, c+1);
//         }
//         if(s.charAt(idx) == ')')
//         {
//             return func(idx+1, s, c-1);
//         }
//         return func(idx+1, s, c+1) || func(idx+1, s, c-1) || func(idx+1, s, c);
//     }
// }

// Optimal Solution (O(N))

class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                min = min + 1;
                max = max + 1;
            }
            else if(s.charAt(i) == ')')
            {
                min = min - 1;
                max = max - 1;
            }
            else
            {
                min = min - 1;
                max = max + 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return (min == 0);
    }
}