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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            // TreeNode node = q.poll();
            int len = q.size();
            List<Integer> ds = new ArrayList<>();
            // ds.add(node.val);
            for(int i=0; i<len; i++)
            {
                if(q.peek().left != null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null)
                {
                    q.offer(q.peek().right);
                }
                ds.add(q.poll().val);
            }
            ans.add(new ArrayList<Integer>(ds));
        }
        return ans;
    }
}