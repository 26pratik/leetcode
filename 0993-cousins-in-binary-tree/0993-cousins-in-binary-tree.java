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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        
        boolean xFound = false;
        boolean yFound = false;
        TreeNode xParent = null;
        TreeNode yParent = null;
        
        q.add(root);
        
        while(!q.isEmpty()) {

            int size = q.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();   

                if(node.val == x) 
                    xFound = true;
                
                if(node.val == y) 
                    yFound = true;
                
                if(node.left != null && node.right != null) {
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.left.val == y && node.right.val == x) return false;
                }
                
                if(node.left != null) 
                    q.add(node.left);
                
                if(node.right != null) 
                    q.add(node.right);
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;            
        }
        
        return false;
    }
}