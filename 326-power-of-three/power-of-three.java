class Solution {
    public boolean isPowerOfThree(int n) {
        return func(n);
    }
    public boolean func(int n)
    {
        if (n == 1) return true;
        if (n <= 0 || n % 3 != 0) return false;
        return func(n / 3);
    }
}