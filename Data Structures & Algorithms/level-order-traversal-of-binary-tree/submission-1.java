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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        dfs(root, list, index);
        return list;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int index) {
        if(node == null)
            return;
        if(list.size() == index)
            list.add(new ArrayList<>());
        list.get(index).add(node.val);
        index++;
        dfs(node.left, list, index);
        dfs(node.right, list, index);
    }
}
