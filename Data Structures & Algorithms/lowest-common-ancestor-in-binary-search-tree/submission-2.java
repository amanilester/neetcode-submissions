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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int s = Math.min(p.val, q.val);
        int b = Math.max(p.val, q.val);
        while(root.val < s)
            root = root.right;
        while(root.val > b)
            root = root.left;
        ancestor(root, s, b);
        return lca;
    }

    private void ancestor(TreeNode node, int s, int b) {
        if(node == null)
            return;
        if(node.val >= s && node.val <= b) {
            lca = node;
            return;
        }
        if(node.val < s)
            ancestor(node.right, s, b);
        else
            ancestor(node.left, s, b);
    }
}
