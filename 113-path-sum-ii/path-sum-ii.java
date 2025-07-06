/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        TreeNode node = root;
        dfs(root, targetSum, 0, ans, ds);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, int sum, List<List<Integer>> ans, List<Integer> ds)
    {
        if (root == null) 
        {
            return;
        }
        sum += root.val;
        ds.add(root.val);
        if (root.left == null && root.right == null && sum == targetSum) 
        {
            ans.add(new ArrayList<>(ds));
        }
        dfs(root.left, targetSum, sum, ans, ds);
        dfs(root.right, targetSum, sum, ans, ds);
        ds.remove(ds.size()-1);  
    }
}