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
        dfs(root, 0);
        return nums.get(k - 1); 
    }

    private void dfs(TreeNode node, int index) {
        if(node == null)
            return;
        nums.add(index, node.val);
        dfs(node.right, index + 1);
        dfs(node.left, index);
    }
}
