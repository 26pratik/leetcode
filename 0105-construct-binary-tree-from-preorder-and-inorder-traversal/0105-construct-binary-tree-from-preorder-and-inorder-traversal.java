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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        map = new HashMap<>();
        index = 0;
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(preorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {

        if(start > end) return null;  
        
        int rootValue = preorder[index];
        index++; 
        int rIdx = map.get(rootValue);
        
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, start, rIdx-1);
        root.right = helper(preorder, rIdx+1, end);
        
        return root;        
    }
}