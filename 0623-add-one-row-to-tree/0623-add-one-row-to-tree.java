class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int d) {
        if (d == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (depth < d - 1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);
            leftNode.left = curr.left;
            rightNode.right = curr.right;
            curr.left = leftNode;
            curr.right = rightNode;
        }

        return root;
    }
}
