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
    HashSet<Integer> indexes;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        indexes = new HashSet<>();
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode node, int index) {
        if(node == null)
            return;
        if(!indexes.contains(index)) {
            list.add(node.val);
            indexes.add(index);
        }
        index++;
        dfs(node.right, index);
        dfs(node.left, index);    
    }
}
