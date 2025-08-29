class Solution {
    public long flowerGame(int n, int m) {
        return func1(n,m) + func2(n,m);
    }
    static long func1(int n, int m)
    {
        long odd = (n+1) / 2;
        long even = m / 2;

        return odd * even;
    }
    static long func2(int n, int m)
    {
        long odd = (m+1) / 2;
        long even = n / 2;

        return odd * even;
    }
}