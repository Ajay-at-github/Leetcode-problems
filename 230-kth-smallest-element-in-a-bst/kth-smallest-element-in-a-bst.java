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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ds = new ArrayList<>();
        dfs(root, ds);
        System.out.print(ds);
        return ds.get(k-1);
    }
    void dfs(TreeNode root, List<Integer> ds)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left, ds);
        ds.add(root.val);
        dfs(root.right, ds);
        
    }
}