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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Stack<TreeNode>s=new Stack<>();
        Stack<TreeNode>q=new Stack<>();
        if(root==null){
            return ans;
        }
        s.push(root);
        while(!s.isEmpty()){
            root=s.pop();
            q.push(root);
            if(root.left!=null){
                s.push(root.left);
            }
            if(root.right!=null){
                s.push(root.right);
            }
        }
        while(!q.isEmpty()){
            ans.add(q.pop().val);
        }
        return ans;
    }
}