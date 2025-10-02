class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            int remainder = empty % numExchange;
            ans += newBottles;
            empty = newBottles + remainder;
        }

        return ans;
    }
}
