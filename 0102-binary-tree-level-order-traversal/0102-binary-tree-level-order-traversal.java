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
//TC: O(n)
//SC: O(n/2) -> O(n)
//BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i<size; i++) {
                
                TreeNode node = q.poll();
                list.add(node.val);
                
                if(node.left != null)
                    q.add(node.left);
                
                if(node.right != null)
                    q.add(node.right);
            }
            
            result.add(list);
        }
        
        return result;
    }
}