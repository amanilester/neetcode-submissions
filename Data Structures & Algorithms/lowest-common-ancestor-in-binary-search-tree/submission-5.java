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
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = root;
        int min;
        int max;
        if(p.val < q.val) {
            min = p.val;
            max = q.val;
        }
        else {
            min = q.val;
            max = p.val;
        }
        dfs(root, min, max);
        return lca;
    }

    public void dfs(TreeNode node, int min, int max) {
        if(node == null)
            return;
        if(node.val >= min && node.val <= max)
            lca = node;
        else if(node.val < min)
            dfs(node.right, min, max);
        else
            dfs(node.left, min, max);
    }
}
