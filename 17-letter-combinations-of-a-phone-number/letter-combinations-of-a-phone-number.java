class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> table = new HashMap<>();
        table.put("2","abc");
        table.put("3","def");
        table.put("4","ghi");
        table.put("5","jkl");
        table.put("6","mno");
        table.put("7","pqrs");
        table.put("8","tuv");
        table.put("9","wxyz");

        List<String> ans = new ArrayList<>();
        if(digits.length()>0)
        {
            helper(0, "", ans, digits, table);
        }
        return ans;
    }
    public static void helper(int i, String str, List<String> ans, String digits, HashMap<String, String> table)
    {
        if(str.length() == digits.length())
        {
            ans.add(str);
            return;
        }
        String key = String.valueOf(digits.charAt(i));
        // System.out.println(key);
        for (char c : table.get(key).toCharArray()) {
            helper(i + 1, str + c, ans, digits, table);
        }
	}
}