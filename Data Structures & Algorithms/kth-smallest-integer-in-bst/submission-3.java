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
    List<Integer> nums;
    public int kthSmallest(TreeNode root, int k) {
        nums = new ArrayList<>(); 
        dfs(root);
        return nums.get(k - 1); 
    }

    private void dfs(TreeNode node) {
        if(node == null)
            return;
        dfs(node.left);
        nums.add(node.val);
        dfs(node.right);
    }
}
