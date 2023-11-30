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
    
    Map<Integer, Integer> map;
    int index;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        map = new HashMap<>();
        index = postorder.length-1;
        
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end) {
        
        if(start > end) return null;
        
        int rootValue = postorder[index--];
        int rootIndex = map.get(rootValue);
        
        TreeNode root = new TreeNode(rootValue);
        root.right = helper(postorder, rootIndex+1, end);        
        root.left = helper(postorder, start, rootIndex-1);
        
        return root;
    }
}