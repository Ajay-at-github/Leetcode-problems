class Solution {
    public List<String> addOperators(String num, int target) 
    {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", num, target, 0, 0, 0);
        return ans;
    }

    public static void backtrack(List<String> ans, String path, String num, int target, int index, long eval, long multed)
    {
        if (index == num.length())
        {
            if (eval == target)
            {
                ans.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) 
        {
            if (i != index && num.charAt(index) == '0') break;
            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);

            if (index == 0) 
            {
                backtrack(ans, path + part, num, target, i + 1, curr, curr);
            }
            else
            {
                backtrack(ans, path + "+" + part, num, target, i + 1, eval + curr, curr);
                backtrack(ans, path + "-" + part, num, target, i + 1, eval - curr, -curr);
                backtrack(ans, path + "*" + part, num, target, i + 1, eval - multed + multed * curr, multed * curr);
            }
        }
    }
}