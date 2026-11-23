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
    List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root, -1);
        return list.get(k - 1);
    }

    public void dfs(TreeNode node, int key) {
        if(node == null)
            return;
        if(key == 0 || node.val < key)
            list.add(list.indexOf(key), node.val);
        else
            list.add(list.indexOf(key) + 1, node.val);
        dfs(node.left, node.val);
        dfs(node.right, node.val);
    }
}
