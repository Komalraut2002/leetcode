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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public static int helper(TreeNode root,int total){
        if(root!=null){
        total=total*10+root.val;
        if(root.left==null && root.right==null){
           return total;
        }
        int sum1=helper(root.left,total);
        int sum2=helper(root.right,total);
        return sum1+sum2;
        }
        else{
            return 0;
        }
    }
}