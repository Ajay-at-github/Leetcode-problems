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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            inMap.put(inorder[i], i);
        }
        TreeNode root = func(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
    }
    private TreeNode func(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd, Map<Integer, Integer> inMap)
    {
        if(preSt > preEnd || inSt > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preSt]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inSt;

        root.left = func(preorder, preSt+1, preSt+numsLeft, inorder, inSt, inRoot-1, inMap);
        root.right = func(preorder, preSt+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        return root;
    }
}