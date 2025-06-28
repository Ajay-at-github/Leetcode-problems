class Solution {
    public char kthCharacter(int k) {
        String str = "a";
        String res = "";
        int len = 0;
        for(int i=0; i<k; i++)
        {
            if(Math.pow(2,i) >= k)
            { 
                len = (int) Math.pow(2,i);
                break;
            }
        }
        // System.out.print(len);
        // helper(str, len, c, res);
        String result = helper(str, len, res);
        // System.out.println(result);
        return result.charAt(k-1);
    }
    public static String helper(String str, int len, String res)
    {
        if(str.length()==len)
        {
            return str;
        }
        for(int i=0; i<str.length(); i++)
        {
            res += (char)(str.charAt(i) + 1);
            // System.out.println(str);
        }
        // System.out.println("BLANK");
        str += res;
        res = "";
        
        return helper(str, len, res);  
    }
}