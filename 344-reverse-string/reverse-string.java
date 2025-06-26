class Solution {
    public void reverseString(char[] s) {
        char temp = ' ';
		helper(temp, s, 0, s.length-1);
	}
	public static char[] helper(char temp, char[] s, int i, int j) {
        if (j < i || i == j) 
        {
            return s;
        }
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return helper(temp, s, i + 1, j - 1);
    }
}