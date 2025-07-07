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

class Tuple
{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _root, int _row, int _col)
    {
        node = _root;
        row = _row;
        col = _col;
    }
}

class Solution 
{
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        
        while(!q.isEmpty())
        {
            Tuple tup = q.poll();
            TreeNode node = tup.node;
            int x = tup.row;
            int y = tup.col;

            if(!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left != null)
            {
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null)
            {
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values())
        {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values())
            {
                while(!nodes.isEmpty())
                {
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}