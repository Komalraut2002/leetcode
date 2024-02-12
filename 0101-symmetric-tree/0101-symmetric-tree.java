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
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root,root);
    }
    static boolean helper(TreeNode leftRoot,TreeNode rightRoot, TreeNode root){
        if(root==null){
            return false;
        }
        if(leftRoot ==null && rightRoot==null){
            return true;
        }
        if(root.left==root.right){
            return true;
        }
        if(leftRoot!=null && rightRoot!=null && leftRoot.val==rightRoot.val){
            boolean left1=helper(leftRoot.left,rightRoot.right,root);
            boolean right1=helper(leftRoot.right,rightRoot.left,root);
            return left1 && right1;
        }
        return false;
    }
}