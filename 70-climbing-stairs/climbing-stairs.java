class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2)
        {
            return n;
        }
        int one = 1;
        int two = 1;
        for(int i=2; i<=n; i++)
        {
            int temp = one;
            one += two;
            two = temp;
        }
        return one;
    }
}