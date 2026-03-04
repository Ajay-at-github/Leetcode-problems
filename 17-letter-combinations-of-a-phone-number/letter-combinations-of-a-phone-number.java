class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> DigitToChar = new HashMap<>();
        DigitToChar.put("2", "abc");
        DigitToChar.put("3", "def");
        DigitToChar.put("4", "ghi");
        DigitToChar.put("5", "jkl");
        DigitToChar.put("6", "mno");
        DigitToChar.put("7", "pqrs");
        DigitToChar.put("8", "tuv");
        DigitToChar.put("9", "wxyz");

        List<String> res = new ArrayList<>();
        String CurrChar = new String();
        int i=0;
        backtrack(0, digits, DigitToChar, CurrChar, res);
        return res;
    }
    public void backtrack(int i, String digits, HashMap<String, String> DigitToChar, String CurrChar, List<String> res)
    {
        if(CurrChar.length() == digits.length())
        {
            res.add(CurrChar);
            return;
        }
        for (char c : DigitToChar.get(String.valueOf(digits.charAt(i))).toCharArray())
        {
            backtrack(i+1, digits, DigitToChar, CurrChar+c, res);
        }
    }
}