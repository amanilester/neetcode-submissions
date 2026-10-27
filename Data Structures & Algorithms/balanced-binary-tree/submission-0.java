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
    boolean b = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return b;
    }

    private int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = 0, right = 0;
        left = 1 + dfs(root.left);
        right = 1 + dfs(root.right);
        if(left - right > 1 || right - left > 1) {
            b = false;
        }
        return Math.max(left, right);
    }
}
