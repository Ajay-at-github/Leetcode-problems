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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode dummy = root;
        while(true)
        {
            if(dummy.val<=val)
            {
                if(dummy.right!=null)
                {
                    dummy = dummy.right;
                }
                else
                {
                    dummy.right = new TreeNode(val);
                    break;
                }
            }
            if(dummy.val>=val)
            {
                if(dummy.left!=null)
                {
                    dummy = dummy.left;
                }
                else
                {
                    dummy.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}