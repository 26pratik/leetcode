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
        Queue<TreeNode> parentQ = new LinkedList<>();
        
        boolean xFound = false;
        boolean yFound = false;
        TreeNode xParent = null;
        TreeNode yParent = null;
        
        q.add(root);
        
        while(!q.isEmpty()) {

            int size = q.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();   
                TreeNode parent = parentQ.poll();
                
                if(node.val == x) {
                    xFound = true;
                    xParent = parent;
                }
                
                if(node.val == y) {
                    yFound = true;
                    yParent = parent;
                }
                
                if(node.left != null) {
                    q.add(node.left);
                    parentQ.add(node);
                }
                
                if(node.right != null) {
                    q.add(node.right);
                    parentQ.add(node);
                }
            }

            if(xFound && yFound) return xParent != yParent;
            if(xFound || yFound) return false;            
        }
        
        return false;
    }
}