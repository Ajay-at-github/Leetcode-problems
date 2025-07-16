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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        // Stack<Integer> s = new Stack<>();
        func(root, ans, 0);
        return ans;
    }
    private void func(TreeNode node, List<Integer>ans, int level)
    {
        if(node == null) return;
        if(level == ans.size()) ans.add(node.val);
        func(node.right, ans, level+1);
        func(node.left, ans, level+1);
    }
}