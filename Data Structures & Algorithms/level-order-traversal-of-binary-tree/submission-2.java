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
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode node, int level) {
        if(node == null)
            return;
        if(list.size() <= level)
            list.add(level, new ArrayList<>());
        list.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
