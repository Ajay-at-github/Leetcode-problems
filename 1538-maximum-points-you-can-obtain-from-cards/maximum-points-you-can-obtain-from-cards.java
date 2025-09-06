class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ls = 0;
        int rs = 0;
        int maxScore = 0;
        int ri = cardPoints.length - 1;
        for(int i=0; i<k; i++)
        {
            ls = ls + cardPoints[i];
        }
        maxScore = ls;
        for(int i=k-1; i>=0; i--)
        {
            ls = ls - cardPoints[i];
            rs = rs + cardPoints[ri];
            ri = ri - 1;
            maxScore = Math.max(maxScore, ls+rs);
        }
        return maxScore;
    }
}