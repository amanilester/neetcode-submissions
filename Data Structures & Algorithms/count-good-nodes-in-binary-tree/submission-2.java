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
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        dfs(root, -101);
        return good;
    }

    public void dfs(TreeNode node, int biggest) {
        if(node == null)
            return;
        if(node.val >= biggest) {
            good++;
            biggest = node.val;
        }
        dfs(node.left, biggest);
        dfs(node.right, biggest);
    }
}
